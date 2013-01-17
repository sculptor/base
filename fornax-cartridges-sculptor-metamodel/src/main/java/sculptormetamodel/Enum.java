/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Enum#getValues <em>Values</em>}</li>
 *   <li>{@link sculptormetamodel.Enum#isOrdinal <em>Ordinal</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getEnum()
 * @model
 * @generated
 */
public interface Enum extends DomainObject {
	/**
     * Returns the value of the '<em><b>Values</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.EnumValue}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getEnum_Values()
     * @model type="sculptormetamodel.EnumValue" containment="true"
     * @generated
     */
	EList getValues();

	/**
     * Returns the value of the '<em><b>Ordinal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ordinal</em>' attribute.
     * @see #setOrdinal(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getEnum_Ordinal()
     * @model
     * @generated
     */
	boolean isOrdinal();

	/**
     * Sets the value of the '{@link sculptormetamodel.Enum#isOrdinal <em>Ordinal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ordinal</em>' attribute.
     * @see #isOrdinal()
     * @generated
     */
	void setOrdinal(boolean value);

} // Enum
