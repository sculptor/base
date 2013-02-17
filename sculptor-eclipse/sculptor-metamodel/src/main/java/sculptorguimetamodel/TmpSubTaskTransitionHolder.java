/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.ecore.EObject;

import sculptormetamodel.DomainObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmp Sub Task Transition Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getToTaskType <em>To Task Type</em>}</li>
 *   <li>{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getTo <em>To</em>}</li>
 *   <li>{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getReferenceHoler <em>Reference Holer</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpSubTaskTransitionHolder()
 * @model
 * @generated
 */
public interface TmpSubTaskTransitionHolder extends EObject {
	/**
     * Returns the value of the '<em><b>To Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Task Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To Task Type</em>' attribute.
     * @see #setToTaskType(String)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpSubTaskTransitionHolder_ToTaskType()
     * @model
     * @generated
     */
	String getToTaskType();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getToTaskType <em>To Task Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To Task Type</em>' attribute.
     * @see #getToTaskType()
     * @generated
     */
	void setToTaskType(String value);

	/**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(DomainObject)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpSubTaskTransitionHolder_To()
     * @model
     * @generated
     */
	DomainObject getTo();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
	void setTo(DomainObject value);

	/**
     * Returns the value of the '<em><b>Reference Holer</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.TmpReferenceHolder#getSubTaskTransitionHolders <em>Sub Task Transition Holders</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Holer</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Reference Holer</em>' container reference.
     * @see #setReferenceHoler(TmpReferenceHolder)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getTmpSubTaskTransitionHolder_ReferenceHoler()
     * @see sculptorguimetamodel.TmpReferenceHolder#getSubTaskTransitionHolders
     * @model opposite="subTaskTransitionHolders" required="true" transient="false"
     * @generated
     */
	TmpReferenceHolder getReferenceHoler();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getReferenceHoler <em>Reference Holer</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference Holer</em>' container reference.
     * @see #getReferenceHoler()
     * @generated
     */
	void setReferenceHoler(TmpReferenceHolder value);

} // TmpSubTaskTransitionHolder
