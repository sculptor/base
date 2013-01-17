/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.common.util.EList;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference View Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.ReferenceViewProperty#getRelatedTransitions <em>Related Transitions</em>}</li>
 *   <li>{@link sculptorguimetamodel.ReferenceViewProperty#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.ReferenceViewProperty#getTarget <em>Target</em>}</li>
 *   <li>{@link sculptorguimetamodel.ReferenceViewProperty#isBase <em>Base</em>}</li>
 *   <li>{@link sculptorguimetamodel.ReferenceViewProperty#getPreviewProperties <em>Preview Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceViewProperty()
 * @model
 * @generated
 */
public interface ReferenceViewProperty extends ViewDataProperty {
    /**
     * Returns the value of the '<em><b>Related Transitions</b></em>' reference list.
     * The list contents are of type {@link sculptorguimetamodel.SubTaskTransition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Related Transitions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Related Transitions</em>' reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceViewProperty_RelatedTransitions()
     * @model type="sculptorguimetamodel.SubTaskTransition"
     * @generated
     */
    EList getRelatedTransitions();

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
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceViewProperty_Reference()
     * @model
     * @generated
     */
    Reference getReference();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.ReferenceViewProperty#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
    void setReference(Reference value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(DomainObject)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceViewProperty_Target()
     * @model
     * @generated
     */
    DomainObject getTarget();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.ReferenceViewProperty#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(DomainObject value);

				/**
     * Returns the value of the '<em><b>Base</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base</em>' attribute.
     * @see #setBase(boolean)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceViewProperty_Base()
     * @model
     * @generated
     */
	boolean isBase();

				/**
     * Sets the value of the '{@link sculptorguimetamodel.ReferenceViewProperty#isBase <em>Base</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base</em>' attribute.
     * @see #isBase()
     * @generated
     */
	void setBase(boolean value);

                /**
     * Returns the value of the '<em><b>Preview Properties</b></em>' reference list.
     * The list contents are of type {@link sculptorguimetamodel.ViewDataProperty}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Preview Properties</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Preview Properties</em>' reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getReferenceViewProperty_PreviewProperties()
     * @model type="sculptorguimetamodel.ViewDataProperty"
     * @generated
     */
    EList getPreviewProperties();

} // ReferenceViewProperty
