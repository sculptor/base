/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import sculptormetamodel.Attribute;
import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Type View Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.BasicTypeViewProperty#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.BasicTypeViewProperty#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getBasicTypeViewProperty()
 * @model
 * @generated
 */
public interface BasicTypeViewProperty extends ViewDataProperty {
    /**
     * Returns the value of the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' reference.
     * @see #setReference(Reference)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getBasicTypeViewProperty_Reference()
     * @model
     * @generated
     */
    Reference getReference();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.BasicTypeViewProperty#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
    void setReference(Reference value);

    /**
     * Returns the value of the '<em><b>Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute</em>' reference.
     * @see #setAttribute(Attribute)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getBasicTypeViewProperty_Attribute()
     * @model
     * @generated
     */
    Attribute getAttribute();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.BasicTypeViewProperty#getAttribute <em>Attribute</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute</em>' reference.
     * @see #getAttribute()
     * @generated
     */
    void setAttribute(Attribute value);

} // BasicTypeViewProperty
