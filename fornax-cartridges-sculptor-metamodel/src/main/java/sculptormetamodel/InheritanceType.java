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
 * A representation of the literals of the enumeration '<em><b>Inheritance Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see sculptormetamodel.SculptormetamodelPackage#getInheritanceType()
 * @model
 * @generated
 */
public final class InheritanceType extends AbstractEnumerator {
    /**
     * The '<em><b>SINGLE TABLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SINGLE TABLE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SINGLE_TABLE_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int SINGLE_TABLE = 0;

    /**
     * The '<em><b>JOINED</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JOINED</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JOINED_LITERAL
     * @model
     * @generated
     * @ordered
     */
    public static final int JOINED = 0;

    /**
     * The '<em><b>SINGLE TABLE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SINGLE_TABLE
     * @generated
     * @ordered
     */
    public static final InheritanceType SINGLE_TABLE_LITERAL = new InheritanceType(SINGLE_TABLE, "SINGLE_TABLE", "SINGLE_TABLE");

    /**
     * The '<em><b>JOINED</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JOINED
     * @generated
     * @ordered
     */
    public static final InheritanceType JOINED_LITERAL = new InheritanceType(JOINED, "JOINED", "JOINED");

    /**
     * An array of all the '<em><b>Inheritance Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final InheritanceType[] VALUES_ARRAY =
        new InheritanceType[] {
            SINGLE_TABLE_LITERAL,
            JOINED_LITERAL,
        };

    /**
     * A public read-only list of all the '<em><b>Inheritance Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Inheritance Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static InheritanceType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            InheritanceType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Inheritance Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static InheritanceType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            InheritanceType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Inheritance Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static InheritanceType get(int value) {
        switch (value) {
            case SINGLE_TABLE: return SINGLE_TABLE_LITERAL;
        }
        return null;
    }

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private InheritanceType(int value, String name, String literal) {
        super(value, name, literal);
    }

} //InheritanceType
