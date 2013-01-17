/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import sculptorguimetamodel.*;

import sculptormetamodel.NamedElement;
import sculptormetamodel.TypedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see sculptorguimetamodel.SculptorguimetamodelPackage
 * @generated
 */
public class SculptorguimetamodelAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static SculptorguimetamodelPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptorguimetamodelAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SculptorguimetamodelPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SculptorguimetamodelSwitch modelSwitch =
		new SculptorguimetamodelSwitch() {
            public Object caseGuiApplication(GuiApplication object) {
                return createGuiApplicationAdapter();
            }
            public Object caseGuiModule(GuiModule object) {
                return createGuiModuleAdapter();
            }
            public Object caseUserTask(UserTask object) {
                return createUserTaskAdapter();
            }
            public Object caseCreateTask(CreateTask object) {
                return createCreateTaskAdapter();
            }
            public Object caseUpdateTask(UpdateTask object) {
                return createUpdateTaskAdapter();
            }
            public Object caseViewTask(ViewTask object) {
                return createViewTaskAdapter();
            }
            public Object caseListTask(ListTask object) {
                return createListTaskAdapter();
            }
            public Object caseDeleteTask(DeleteTask object) {
                return createDeleteTaskAdapter();
            }
            public Object caseSubTaskTransition(SubTaskTransition object) {
                return createSubTaskTransitionAdapter();
            }
            public Object caseViewDataProperty(ViewDataProperty object) {
                return createViewDataPropertyAdapter();
            }
            public Object caseTmpReferenceHolder(TmpReferenceHolder object) {
                return createTmpReferenceHolderAdapter();
            }
            public Object caseTmpSubTaskTransitionHolder(TmpSubTaskTransitionHolder object) {
                return createTmpSubTaskTransitionHolderAdapter();
            }
            public Object caseReferenceTarget(ReferenceTarget object) {
                return createReferenceTargetAdapter();
            }
            public Object caseReferenceViewProperty(ReferenceViewProperty object) {
                return createReferenceViewPropertyAdapter();
            }
            public Object caseAttributeViewProperty(AttributeViewProperty object) {
                return createAttributeViewPropertyAdapter();
            }
            public Object caseBasicTypeViewProperty(BasicTypeViewProperty object) {
                return createBasicTypeViewPropertyAdapter();
            }
            public Object caseEnumViewProperty(EnumViewProperty object) {
                return createEnumViewPropertyAdapter();
            }
            public Object caseBasicTypeEnumViewProperty(BasicTypeEnumViewProperty object) {
                return createBasicTypeEnumViewPropertyAdapter();
            }
            public Object caseUserTaskGroup(UserTaskGroup object) {
                return createUserTaskGroupAdapter();
            }
            public Object caseDerivedReferenceViewProperty(DerivedReferenceViewProperty object) {
                return createDerivedReferenceViewPropertyAdapter();
            }
            public Object caseAddTask(AddTask object) {
                return createAddTaskAdapter();
            }
            public Object caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            public Object defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	public Adapter createAdapter(Notifier target) {
        return (Adapter)modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.GuiApplication <em>Gui Application</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.GuiApplication
     * @generated
     */
	public Adapter createGuiApplicationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.GuiModule <em>Gui Module</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.GuiModule
     * @generated
     */
	public Adapter createGuiModuleAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.UserTask <em>User Task</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.UserTask
     * @generated
     */
	public Adapter createUserTaskAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.CreateTask <em>Create Task</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.CreateTask
     * @generated
     */
	public Adapter createCreateTaskAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.UpdateTask <em>Update Task</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.UpdateTask
     * @generated
     */
	public Adapter createUpdateTaskAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.ViewTask <em>View Task</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.ViewTask
     * @generated
     */
	public Adapter createViewTaskAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.ListTask <em>List Task</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.ListTask
     * @generated
     */
	public Adapter createListTaskAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.DeleteTask <em>Delete Task</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.DeleteTask
     * @generated
     */
	public Adapter createDeleteTaskAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.SubTaskTransition <em>Sub Task Transition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.SubTaskTransition
     * @generated
     */
	public Adapter createSubTaskTransitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.ViewDataProperty <em>View Data Property</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.ViewDataProperty
     * @generated
     */
	public Adapter createViewDataPropertyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.TmpReferenceHolder <em>Tmp Reference Holder</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.TmpReferenceHolder
     * @generated
     */
	public Adapter createTmpReferenceHolderAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder <em>Tmp Sub Task Transition Holder</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.TmpSubTaskTransitionHolder
     * @generated
     */
	public Adapter createTmpSubTaskTransitionHolderAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.ReferenceTarget <em>Reference Target</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.ReferenceTarget
     * @generated
     */
    public Adapter createReferenceTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.ReferenceViewProperty <em>Reference View Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.ReferenceViewProperty
     * @generated
     */
    public Adapter createReferenceViewPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.AttributeViewProperty <em>Attribute View Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.AttributeViewProperty
     * @generated
     */
    public Adapter createAttributeViewPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.BasicTypeViewProperty <em>Basic Type View Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.BasicTypeViewProperty
     * @generated
     */
    public Adapter createBasicTypeViewPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.EnumViewProperty <em>Enum View Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.EnumViewProperty
     * @generated
     */
    public Adapter createEnumViewPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.BasicTypeEnumViewProperty <em>Basic Type Enum View Property</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.BasicTypeEnumViewProperty
     * @generated
     */
	public Adapter createBasicTypeEnumViewPropertyAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.UserTaskGroup <em>User Task Group</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.UserTaskGroup
     * @generated
     */
	public Adapter createUserTaskGroupAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.DerivedReferenceViewProperty <em>Derived Reference View Property</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.DerivedReferenceViewProperty
     * @generated
     */
	public Adapter createDerivedReferenceViewPropertyAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link sculptorguimetamodel.AddTask <em>Add Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptorguimetamodel.AddTask
     * @generated
     */
    public Adapter createAddTaskAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.NamedElement
     * @generated
     */
	public Adapter createNamedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //SculptorguimetamodelAdapterFactory
