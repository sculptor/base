/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Discriminator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see sculptormetamodel.SculptormetamodelPackage#getDiscriminatorType()
 * @model
 * @generated
 */
public final class DiscriminatorType extends AbstractEnumerator {
    /**
     * The '<em><b>STRING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>STRING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #STRING_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int STRING = 0;

    /**
     * The '<em><b>CHAR</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CHAR</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CHAR_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int CHAR = 0;

    /**
     * The '<em><b>INTEGER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INTEGER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INTEGER_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int INTEGER = 0;

    /**
     * The '<em><b>STRING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #STRING
     * @generated
     * @ordered
     */
    public static final DiscriminatorType STRING_LITERAL = new DiscriminatorType(STRING, "STRING", "STRING");

    /**
     * The '<em><b>CHAR</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CHAR
     * @generated
     * @ordered
     */
    public static final DiscriminatorType CHAR_LITERAL = new DiscriminatorType(CHAR, "CHAR", "CHAR");

    /**
     * The '<em><b>INTEGER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTEGER
     * @generated
     * @ordered
     */
    public static final DiscriminatorType INTEGER_LITERAL = new DiscriminatorType(INTEGER, "INTEGER", "INTEGER");

    /**
     * An array of all the '<em><b>Discriminator Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final DiscriminatorType[] VALUES_ARRAY =
        new DiscriminatorType[] {
            STRING_LITERAL,
            CHAR_LITERAL,
            INTEGER_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Discriminator Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Discriminator Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DiscriminatorType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DiscriminatorType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Discriminator Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DiscriminatorType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DiscriminatorType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Discriminator Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DiscriminatorType get(int value) {
        switch (value) {
            case STRING: return STRING_LITERAL;
        }
        return null;
    }

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private DiscriminatorType(int value, String name, String literal) {
        super(value, name, literal);
    }

} //DiscriminatorType
