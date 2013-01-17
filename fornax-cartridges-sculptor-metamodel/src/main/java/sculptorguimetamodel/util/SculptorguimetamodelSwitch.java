/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import sculptorguimetamodel.*;

import sculptormetamodel.NamedElement;
import sculptormetamodel.TypedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see sculptorguimetamodel.SculptorguimetamodelPackage
 * @generated
 */
public class SculptorguimetamodelSwitch {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static SculptorguimetamodelPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptorguimetamodelSwitch() {
        if (modelPackage == null) {
            modelPackage = SculptorguimetamodelPackage.eINSTANCE;
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public Object doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch((EClass)eSuperTypes.get(0), theEObject);
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected Object doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case SculptorguimetamodelPackage.GUI_APPLICATION: {
                GuiApplication guiApplication = (GuiApplication)theEObject;
                Object result = caseGuiApplication(guiApplication);
                if (result == null) result = caseNamedElement(guiApplication);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.GUI_MODULE: {
                GuiModule guiModule = (GuiModule)theEObject;
                Object result = caseGuiModule(guiModule);
                if (result == null) result = caseNamedElement(guiModule);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.USER_TASK: {
                UserTask userTask = (UserTask)theEObject;
                Object result = caseUserTask(userTask);
                if (result == null) result = caseNamedElement(userTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.CREATE_TASK: {
                CreateTask createTask = (CreateTask)theEObject;
                Object result = caseCreateTask(createTask);
                if (result == null) result = caseUserTask(createTask);
                if (result == null) result = caseNamedElement(createTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.UPDATE_TASK: {
                UpdateTask updateTask = (UpdateTask)theEObject;
                Object result = caseUpdateTask(updateTask);
                if (result == null) result = caseUserTask(updateTask);
                if (result == null) result = caseNamedElement(updateTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.VIEW_TASK: {
                ViewTask viewTask = (ViewTask)theEObject;
                Object result = caseViewTask(viewTask);
                if (result == null) result = caseUserTask(viewTask);
                if (result == null) result = caseNamedElement(viewTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.LIST_TASK: {
                ListTask listTask = (ListTask)theEObject;
                Object result = caseListTask(listTask);
                if (result == null) result = caseUserTask(listTask);
                if (result == null) result = caseNamedElement(listTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.DELETE_TASK: {
                DeleteTask deleteTask = (DeleteTask)theEObject;
                Object result = caseDeleteTask(deleteTask);
                if (result == null) result = caseUserTask(deleteTask);
                if (result == null) result = caseNamedElement(deleteTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION: {
                SubTaskTransition subTaskTransition = (SubTaskTransition)theEObject;
                Object result = caseSubTaskTransition(subTaskTransition);
                if (result == null) result = caseNamedElement(subTaskTransition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY: {
                ViewDataProperty viewDataProperty = (ViewDataProperty)theEObject;
                Object result = caseViewDataProperty(viewDataProperty);
                if (result == null) result = caseNamedElement(viewDataProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER: {
                TmpReferenceHolder tmpReferenceHolder = (TmpReferenceHolder)theEObject;
                Object result = caseTmpReferenceHolder(tmpReferenceHolder);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER: {
                TmpSubTaskTransitionHolder tmpSubTaskTransitionHolder = (TmpSubTaskTransitionHolder)theEObject;
                Object result = caseTmpSubTaskTransitionHolder(tmpSubTaskTransitionHolder);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.REFERENCE_TARGET: {
                ReferenceTarget referenceTarget = (ReferenceTarget)theEObject;
                Object result = caseReferenceTarget(referenceTarget);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY: {
                ReferenceViewProperty referenceViewProperty = (ReferenceViewProperty)theEObject;
                Object result = caseReferenceViewProperty(referenceViewProperty);
                if (result == null) result = caseViewDataProperty(referenceViewProperty);
                if (result == null) result = caseNamedElement(referenceViewProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.ATTRIBUTE_VIEW_PROPERTY: {
                AttributeViewProperty attributeViewProperty = (AttributeViewProperty)theEObject;
                Object result = caseAttributeViewProperty(attributeViewProperty);
                if (result == null) result = caseViewDataProperty(attributeViewProperty);
                if (result == null) result = caseNamedElement(attributeViewProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY: {
                BasicTypeViewProperty basicTypeViewProperty = (BasicTypeViewProperty)theEObject;
                Object result = caseBasicTypeViewProperty(basicTypeViewProperty);
                if (result == null) result = caseViewDataProperty(basicTypeViewProperty);
                if (result == null) result = caseNamedElement(basicTypeViewProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.ENUM_VIEW_PROPERTY: {
                EnumViewProperty enumViewProperty = (EnumViewProperty)theEObject;
                Object result = caseEnumViewProperty(enumViewProperty);
                if (result == null) result = caseViewDataProperty(enumViewProperty);
                if (result == null) result = caseNamedElement(enumViewProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY: {
                BasicTypeEnumViewProperty basicTypeEnumViewProperty = (BasicTypeEnumViewProperty)theEObject;
                Object result = caseBasicTypeEnumViewProperty(basicTypeEnumViewProperty);
                if (result == null) result = caseEnumViewProperty(basicTypeEnumViewProperty);
                if (result == null) result = caseViewDataProperty(basicTypeEnumViewProperty);
                if (result == null) result = caseNamedElement(basicTypeEnumViewProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.USER_TASK_GROUP: {
                UserTaskGroup userTaskGroup = (UserTaskGroup)theEObject;
                Object result = caseUserTaskGroup(userTaskGroup);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY: {
                DerivedReferenceViewProperty derivedReferenceViewProperty = (DerivedReferenceViewProperty)theEObject;
                Object result = caseDerivedReferenceViewProperty(derivedReferenceViewProperty);
                if (result == null) result = caseReferenceViewProperty(derivedReferenceViewProperty);
                if (result == null) result = caseViewDataProperty(derivedReferenceViewProperty);
                if (result == null) result = caseNamedElement(derivedReferenceViewProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptorguimetamodelPackage.ADD_TASK: {
                AddTask addTask = (AddTask)theEObject;
                Object result = caseAddTask(addTask);
                if (result == null) result = caseUserTask(addTask);
                if (result == null) result = caseNamedElement(addTask);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Gui Application</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Gui Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseGuiApplication(GuiApplication object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Gui Module</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Gui Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseGuiModule(GuiModule object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>User Task</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseUserTask(UserTask object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Create Task</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Create Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseCreateTask(CreateTask object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Update Task</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseUpdateTask(UpdateTask object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>View Task</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseViewTask(ViewTask object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>List Task</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>List Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseListTask(ListTask object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Delete Task</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delete Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseDeleteTask(DeleteTask object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sub Task Transition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sub Task Transition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseSubTaskTransition(SubTaskTransition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>View Data Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Data Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseViewDataProperty(ViewDataProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tmp Reference Holder</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tmp Reference Holder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseTmpReferenceHolder(TmpReferenceHolder object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tmp Sub Task Transition Holder</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tmp Sub Task Transition Holder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseTmpSubTaskTransitionHolder(TmpSubTaskTransitionHolder object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Reference Target</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reference Target</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseReferenceTarget(ReferenceTarget object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reference View Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reference View Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseReferenceViewProperty(ReferenceViewProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute View Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute View Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAttributeViewProperty(AttributeViewProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Basic Type View Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Basic Type View Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseBasicTypeViewProperty(BasicTypeViewProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enum View Property</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum View Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEnumViewProperty(EnumViewProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Basic Type Enum View Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Basic Type Enum View Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseBasicTypeEnumViewProperty(BasicTypeEnumViewProperty object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>User Task Group</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User Task Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseUserTaskGroup(UserTaskGroup object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>Derived Reference View Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Derived Reference View Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseDerivedReferenceViewProperty(DerivedReferenceViewProperty object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>Add Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Add Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAddTask(AddTask object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseNamedElement(NamedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public Object defaultCase(EObject object) {
        return null;
    }

} //SculptorguimetamodelSwitch
