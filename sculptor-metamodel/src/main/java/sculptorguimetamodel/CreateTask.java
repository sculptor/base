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
 * A representation of the model object '<em><b>Create Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.CreateTask#getCreateDOWith <em>Create DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.CreateTask#getPopulateDOWith <em>Populate DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getCreateTask()
 * @model
 * @generated
 */
public interface CreateTask extends UserTask {
	/**
     * Returns the value of the '<em><b>Create DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create DO With</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Create DO With</em>' reference.
     * @see #setCreateDOWith(ServiceOperation)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getCreateTask_CreateDOWith()
     * @model
     * @generated
     */
	ServiceOperation getCreateDOWith();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.CreateTask#getCreateDOWith <em>Create DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Create DO With</em>' reference.
     * @see #getCreateDOWith()
     * @generated
     */
	void setCreateDOWith(ServiceOperation value);

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
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getCreateTask_PopulateDOWith()
     * @model
     * @generated
     */
    ServiceOperation getPopulateDOWith();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.CreateTask#getPopulateDOWith <em>Populate DO With</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Populate DO With</em>' reference.
     * @see #getPopulateDOWith()
     * @generated
     */
    void setPopulateDOWith(ServiceOperation value);

} // CreateTask
