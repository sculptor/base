/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmp Reference Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.TmpReferenceHolder#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.TmpReferenceHolder#getSubTaskTransitionHolders <em>Sub Task Transition Holders</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpReferenceHolder()
 * @model
 * @generated
 */
public interface TmpReferenceHolder extends EObject {
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
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpReferenceHolder_Reference()
     * @model
     * @generated
     */
	Reference getReference();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.TmpReferenceHolder#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
	void setReference(Reference value);

	/**
     * Returns the value of the '<em><b>Sub Task Transition Holders</b></em>' containment reference list.
     * The list contents are of type {@link sculptorguimetamodel.TmpSubTaskTransitionHolder}.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getReferenceHoler <em>Reference Holer</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Task Transition Holders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Task Transition Holders</em>' containment reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpReferenceHolder_SubTaskTransitionHolders()
     * @see sculptorguimetamodel.TmpSubTaskTransitionHolder#getReferenceHoler
     * @model type="sculptorguimetamodel.TmpSubTaskTransitionHolder" opposite="referenceHoler" containment="true"
     * @generated
     */
	EList getSubTaskTransitionHolders();

} // TmpReferenceHolder
