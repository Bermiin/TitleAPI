package me.bermine.titleapi.util;

/**
 * An interface for retrieving the field content.
 *
 * @param <T> field type.
 *
 * @author Kristian
 * @version TinyProtocol
 * @since 08/07/2024
 */
public interface FieldAccessor<T> {
    /**
     * Retrieve the content of a field.
     *
     * @param target - the target object, or NULL for a static field.
     * @return The value of the field.
     */
    T get(Object target);

    /**
     * Set the content of a field.
     *
     * @param target - the target object, or NULL for a static field.
     * @param value  - the new value of the field.
     */
    void set(Object target, Object value);

    /**
     * Determine if the given object has this field.
     *
     * @param target - the object to test.
     * @return TRUE if it does, FALSE otherwise.
     */
    boolean hasField(Object target);
}