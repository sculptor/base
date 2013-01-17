/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.common.util.EList;

import sculptormetamodel.DomainObject;
import sculptormetamodel.NamedElement;
import sculptormetamodel.Service;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.UserTask#getSubTaskTransitions <em>Sub Task Transitions</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#getFor <em>For</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#getModule <em>Module</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#getTaskType <em>Task Type</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#getViewProperties <em>View Properties</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#isConversationRoot <em>Conversation Root</em>}</li>
 *   <li>{@link sculptorguimetamodel.UserTask#isGapClass <em>Gap Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask()
 * @model
 * @generated
 */
public interface UserTask extends NamedElement {
	/**
     * Returns the value of the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * The list contents are of type {@link sculptorguimetamodel.SubTaskTransition}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Task Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Task Transitions</em>' containment reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_SubTaskTransitions()
     * @model type="sculptorguimetamodel.SubTaskTransition" containment="true"
     * @generated
     */
	EList getSubTaskTransitions();

	/**
     * Returns the value of the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>For</em>' reference.
     * @see #setFor(DomainObject)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_For()
     * @model required="true"
     * @generated
     */
	DomainObject getFor();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.UserTask#getFor <em>For</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>For</em>' reference.
     * @see #getFor()
     * @generated
     */
	void setFor(DomainObject value);

	/**
     * Returns the value of the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abstract</em>' attribute.
     * @see #setAbstract(Boolean)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_Abstract()
     * @model
     * @generated
     */
	Boolean getAbstract();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.UserTask#getAbstract <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abstract</em>' attribute.
     * @see #getAbstract()
     * @generated
     */
	void setAbstract(Boolean value);

	/**
     * Returns the value of the '<em><b>Module</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.GuiModule#getUserTasks <em>User Tasks</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Module</em>' container reference.
     * @see #setModule(GuiModule)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_Module()
     * @see sculptorguimetamodel.GuiModule#getUserTasks
     * @model opposite="userTasks" transient="false"
     * @generated
     */
	GuiModule getModule();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.UserTask#getModule <em>Module</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Module</em>' container reference.
     * @see #getModule()
     * @generated
     */
	void setModule(GuiModule value);

	/**
     * Returns the value of the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Task Type</em>' attribute.
     * @see #setTaskType(String)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_TaskType()
     * @model
     * @generated
     */
	String getTaskType();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.UserTask#getTaskType <em>Task Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Task Type</em>' attribute.
     * @see #getTaskType()
     * @generated
     */
	void setTaskType(String value);

    /**
     * Returns the value of the '<em><b>View Properties</b></em>' containment reference list.
     * The list contents are of type {@link sculptorguimetamodel.ViewDataProperty}.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.ViewDataProperty#getUserTask <em>User Task</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View Properties</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>View Properties</em>' containment reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_ViewProperties()
     * @see sculptorguimetamodel.ViewDataProperty#getUserTask
     * @model type="sculptorguimetamodel.ViewDataProperty" opposite="userTask" containment="true"
     * @generated
     */
    EList getViewProperties();

    /**
     * Returns the value of the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Conversation Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Conversation Root</em>' attribute.
     * @see #setConversationRoot(boolean)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_ConversationRoot()
     * @model
     * @generated
     */
    boolean isConversationRoot();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.UserTask#isConversationRoot <em>Conversation Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Conversation Root</em>' attribute.
     * @see #isConversationRoot()
     * @generated
     */
    void setConversationRoot(boolean value);

    /**
     * Returns the value of the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gap Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gap Class</em>' attribute.
     * @see #setGapClass(boolean)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getUserTask_GapClass()
     * @model
     * @generated
     */
    boolean isGapClass();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.UserTask#isGapClass <em>Gap Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gap Class</em>' attribute.
     * @see #isGapClass()
     * @generated
     */
    void setGapClass(boolean value);

} // UserTask
