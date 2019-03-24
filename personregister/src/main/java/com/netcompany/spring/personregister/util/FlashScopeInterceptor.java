package com.netcompany.spring.personregister.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Henter flashScope attributter fra kontrollere og legger de i sesjonen slik at de kan brukes ved neste request.
 *
 * <p>Hentet fra: http://jira.springframework.org/browse/MOD-458</p>
 *
 * <p>Brukes i en kontroller f.eks slik:<br />
 *    <code>FlashScopeHjelper.leggTilSuksessMelding(modell, "melding.oppdatering.vellykket");<br />
 *          return "redirect:" + EnAnnenKontroller.URL;
 *    </code>
 * </p>
 *
 * @author Geert Pante
 */
public class FlashScopeInterceptor implements HandlerInterceptor {

    public static final String DEFAULT_ATTRIBUTE_NAME = "flashScope";
    public static final String DEFAULT_SESSION_ATTRIBUTE_NAME = FlashScopeInterceptor.class.getName();
    public static final int DEFAULT_RETENTION_COUNT = 2;

    private final String sessionAttributeName = DEFAULT_SESSION_ATTRIBUTE_NAME;
    private final String attributeName = DEFAULT_ATTRIBUTE_NAME;
    private final int retentionCount = DEFAULT_RETENTION_COUNT;

    /**
     * Binds session flashScope to current request, if not empty. Otherwise
     * cleans up empty flashScope
     */
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handler) {
        final HttpSession session = request.getSession(false);

        if (session != null) {
            final Object sessionAttribute = session.getAttribute(this.sessionAttributeName);

            if (sessionAttribute instanceof MultiScopeModelMap) {
                final MultiScopeModelMap flashScope = (MultiScopeModelMap) sessionAttribute;

                if (flashScope.isEmpty()) {
                    session.removeAttribute(this.sessionAttributeName);
                } else {
                    request.setAttribute(this.attributeName, flashScope);
                }
            }
        }

        return true;
    }

    /**
     * Merge modelAndView.model['flashScope'] to current flashScope.
     */
    @SuppressWarnings("unchecked")
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
                           final Object handler, final ModelAndView modelAndView) {
        if (modelAndView != null) {
            Map<String, Object> modelFlashScopeMap = null;
            final Iterator<Entry<String, Object>> iterator = (modelAndView.getModel()).entrySet().iterator();

            while (iterator.hasNext()) {
                final Entry<String, Object> entry = iterator.next();

                if (this.attributeName.equals(entry.getKey()) && entry.getValue() instanceof Map) {
                    if (modelFlashScopeMap == null) {
                        modelFlashScopeMap = (Map) entry.getValue();
                    } else {
                        modelFlashScopeMap.putAll((Map) entry.getValue());
                    }

                    iterator.remove();
                } else if (entry.getKey().startsWith(this.attributeName + ".")) {
                    final String key = entry.getKey().substring(this.attributeName.length() + 1);

                    if (modelFlashScopeMap == null) {
                        modelFlashScopeMap = new HashMap<String, Object>();
                    }

                    modelFlashScopeMap.put(key, entry.getValue());
                    iterator.remove();
                }
            }

            if (modelFlashScopeMap != null) {
                MultiScopeModelMap flashScopeMap;

                if (request.getAttribute(this.attributeName) instanceof MultiScopeModelMap) {
                    flashScopeMap = (MultiScopeModelMap) request.getAttribute(this.attributeName);
                } else {
                    flashScopeMap = new MultiScopeModelMap(this.retentionCount);
                }

                flashScopeMap.putAll(modelFlashScopeMap);
                request.setAttribute(this.attributeName, flashScopeMap);
            }
        }
    }

    /**
     * Unbinds current flashScope from session. Rolls request's flashScope to
     * the next scope. Binds request's flashScope, if not empty, to the session.
     */
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
                                final Object handler, final Exception ex) {
        if (request.getSession(false) != null) {
            request.getSession().removeAttribute(this.sessionAttributeName);
        }

        final Object requestAttribute = request.getAttribute(this.attributeName);

        if (requestAttribute instanceof MultiScopeModelMap) {
            final MultiScopeModelMap attributes = (MultiScopeModelMap) requestAttribute;

            if (!attributes.isEmpty()) {
                attributes.next();

                if (!attributes.isEmpty()) {
                    request.getSession(true).setAttribute(this.sessionAttributeName, attributes);
                }
            }
        }
    }
}
