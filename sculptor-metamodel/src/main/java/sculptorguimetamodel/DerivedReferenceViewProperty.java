/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Reference View Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.DerivedReferenceViewProperty#getDerivedFrom <em>Derived From</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getDerivedReferenceViewProperty()
 * @model
 * @generated
 */
public interface DerivedReferenceViewProperty extends ReferenceViewProperty {
	/**
     * Returns the value of the '<em><b>Derived From</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Derived From</em>' reference.
     * @see #setDerivedFrom(ReferenceViewProperty)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getDerivedReferenceViewProperty_DerivedFrom()
     * @model required="true"
     * @generated
     */
	ReferenceViewProperty getDerivedFrom();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.DerivedReferenceViewProperty#getDerivedFrom <em>Derived From</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Derived From</em>' reference.
     * @see #getDerivedFrom()
     * @generated
     */
	void setDerivedFrom(ReferenceViewProperty value);

} // DerivedReferenceViewProperty
