package no.mesan.spring.personregister.util;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Implementasjon av {@link InternalResourceViewResolver} som sørger for at {@link RedirectView}
 * ikke legger på alle modell-attributtene i url'en.
 *
 * @author Christian Ihle
 */
public class RedirectUtenParametreInternalResourceViewResolver extends InternalResourceViewResolver {

    @Override
    protected View createView(final String viewName, final Locale locale) throws Exception {
        final View view = super.createView(viewName, locale);

        if (view instanceof RedirectView) {
            final RedirectView redirectView = (RedirectView) view;
            redirectView.setExposeModelAttributes(false);
        }

        return view;
    }
}
