package no.mesan.spring.personregister.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.CompositeMap;
import org.apache.commons.collections.map.CompositeMap.MapMutator;

/**
 * Implements a flash scoped map. Scopes are changed using {@link #next()}.
 * Items are retained during the current scope and the next, but no longer.
 * Inspired by GrailsFlashScope.
 *
 * <p>Hentet fra: http://jira.springframework.org/browse/MOD-458</p>
 *
 * @author Geert Pante
 */
@SuppressWarnings("unchecked")
public class MultiScopeModelMap extends CompositeMap implements Serializable, MapMutator {
    // CHECKSTYLE:OFF
    private static final long serialVersionUID = 1L;

    /** Shadows composite map. */
    private final LinkedList<Map> maps = new LinkedList<Map>();

    public MultiScopeModelMap(final int num) {
        super();
        setMutator(this);

        for (int i = 0; i < num; ++i) {
            addComposited(new HashMap());
        }
    }

    @Override
    public synchronized void addComposited(final Map map) throws IllegalArgumentException {
        super.addComposited(map);
        this.maps.addLast(map);
    }

    @Override
    public synchronized Map removeComposited(final Map map) {
        final Map removed = super.removeComposited(map);
        this.maps.remove(map);
        return removed;
    }

    /**
     * Starts a new scope. All items added in the session before the previous
     * session are removed. All items added in the previous scope are still
     * retrievable and removable.
     */
    public void next() {
        removeComposited(this.maps.getFirst());
        addComposited(new HashMap());
    }

    public Object put(final CompositeMap map, final Map[] composited, final Object key, final Object value) {
        if (composited.length < 1) {
            throw new UnsupportedOperationException("No composites to add elements to");
        }

        final Object result = map.get(key);
        if (result != null) {
            map.remove(key);
        }

        composited[composited.length - 1].put(key, value);

        return result;
    }

    public void putAll(final CompositeMap map, final Map[] composited, final Map mapToAdd) {
        for (final Entry entry : (Set<Entry>) mapToAdd.entrySet()) {
            put(map, composited, entry.getKey(), entry.getValue());
        }
    }

    public void resolveCollision(final CompositeMap composite, final Map existing, final Map added,
                                 final Collection intersect) {
        existing.keySet().removeAll(intersect);
    }

    @Override
    public String toString() {
        return new HashMap(this).toString();
    }
    // CHECKSTYLE:ON
}
