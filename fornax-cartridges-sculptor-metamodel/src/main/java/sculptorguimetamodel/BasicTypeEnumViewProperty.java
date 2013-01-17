/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type Enum View Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.BasicTypeEnumViewProperty#getBasicTypeReference <em>Basic Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getBasicTypeEnumViewProperty()
 * @model
 * @generated
 */
public interface BasicTypeEnumViewProperty extends EnumViewProperty {
	/**
     * Returns the value of the '<em><b>Basic Type Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Type Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Basic Type Reference</em>' reference.
     * @see #setBasicTypeReference(Reference)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getBasicTypeEnumViewProperty_BasicTypeReference()
     * @model
     * @generated
     */
	Reference getBasicTypeReference();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.BasicTypeEnumViewProperty#getBasicTypeReference <em>Basic Type Reference</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Basic Type Reference</em>' reference.
     * @see #getBasicTypeReference()
     * @generated
     */
	void setBasicTypeReference(Reference value);

} // BasicTypeEnumViewProperty
