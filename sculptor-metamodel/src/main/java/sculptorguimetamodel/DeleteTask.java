/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.DeleteTask#getFindDOWith <em>Find DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.DeleteTask#getDeleteDOWith <em>Delete DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getDeleteTask()
 * @model
 * @generated
 */
public interface DeleteTask extends UserTask {
	/**
     * Returns the value of the '<em><b>Find DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Find DO With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Find DO With</em>' reference.
     * @see #setFindDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getDeleteTask_FindDOWith()
     * @model
     * @generated
     */
	ServiceOperation getFindDOWith();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.DeleteTask#getFindDOWith <em>Find DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Find DO With</em>' reference.
     * @see #getFindDOWith()
     * @generated
     */
	void setFindDOWith(ServiceOperation value);

	/**
     * Returns the value of the '<em><b>Delete DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete DO With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Delete DO With</em>' reference.
     * @see #setDeleteDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getDeleteTask_DeleteDOWith()
     * @model
     * @generated
     */
	ServiceOperation getDeleteDOWith();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.DeleteTask#getDeleteDOWith <em>Delete DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delete DO With</em>' reference.
     * @see #getDeleteDOWith()
     * @generated
     */
	void setDeleteDOWith(ServiceOperation value);

} // DeleteTask
