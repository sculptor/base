/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Taskw Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTaskwType()
 * @model
 * @generated
 */
public final class TaskwType extends AbstractEnumerator {
	/**
	 * The '<em><b>CREATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CREATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CREATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREATE = 0;

	/**
	 * The '<em><b>UPDATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UPDATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPDATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE = 0;

	/**
	 * The '<em><b>VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VIEW = 0;

	/**
	 * The '<em><b>LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIST = 0;

	/**
	 * The '<em><b>DELETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE = 0;

	/**
	 * The '<em><b>CREATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREATE
	 * @generated
	 * @ordered
	 */
	public static final TaskwType CREATE_LITERAL = new TaskwType(CREATE, "CREATE", "CREATE");

	/**
	 * The '<em><b>UPDATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE
	 * @generated
	 * @ordered
	 */
	public static final TaskwType UPDATE_LITERAL = new TaskwType(UPDATE, "UPDATE", "UPDATE");

	/**
	 * The '<em><b>VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEW
	 * @generated
	 * @ordered
	 */
	public static final TaskwType VIEW_LITERAL = new TaskwType(VIEW, "VIEW", "VIEW");

	/**
	 * The '<em><b>LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST
	 * @generated
	 * @ordered
	 */
	public static final TaskwType LIST_LITERAL = new TaskwType(LIST, "LIST", "LIST");

	/**
	 * The '<em><b>DELETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE
	 * @generated
	 * @ordered
	 */
	public static final TaskwType DELETE_LITERAL = new TaskwType(DELETE, "DELETE", "DELETE");

	/**
	 * An array of all the '<em><b>Taskw Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TaskwType[] VALUES_ARRAY =
		new TaskwType[] {
			CREATE_LITERAL,
			UPDATE_LITERAL,
			VIEW_LITERAL,
			LIST_LITERAL,
			DELETE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Taskw Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Taskw Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TaskwType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TaskwType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Taskw Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TaskwType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TaskwType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Taskw Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TaskwType get(int value) {
		switch (value) {
			case CREATE: return CREATE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TaskwType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TaskwType
