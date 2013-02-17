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
 * A representation of the model object '<em><b>Update Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.UpdateTask#getFindDOWith <em>Find DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.UpdateTask#getUpdateDOWith <em>Update DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.UpdateTask#getPopulateDOWith <em>Populate DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUpdateTask()
 * @model
 * @generated
 */
public interface UpdateTask extends UserTask {
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
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUpdateTask_FindDOWith()
     * @model
     * @generated
     */
	ServiceOperation getFindDOWith();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.UpdateTask#getFindDOWith <em>Find DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Find DO With</em>' reference.
     * @see #getFindDOWith()
     * @generated
     */
	void setFindDOWith(ServiceOperation value);

	/**
     * Returns the value of the '<em><b>Update DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update DO With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Update DO With</em>' reference.
     * @see #setUpdateDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUpdateTask_UpdateDOWith()
     * @model
     * @generated
     */
	ServiceOperation getUpdateDOWith();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.UpdateTask#getUpdateDOWith <em>Update DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Update DO With</em>' reference.
     * @see #getUpdateDOWith()
     * @generated
     */
	void setUpdateDOWith(ServiceOperation value);

    /**
     * Returns the value of the '<em><b>Populate DO With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Populate DO With</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Populate DO With</em>' reference.
     * @see #setPopulateDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUpdateTask_PopulateDOWith()
     * @model
     * @generated
     */
    ServiceOperation getPopulateDOWith();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.UpdateTask#getPopulateDOWith <em>Populate DO With</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Populate DO With</em>' reference.
     * @see #getPopulateDOWith()
     * @generated
     */
    void setPopulateDOWith(ServiceOperation value);

} // UpdateTask
