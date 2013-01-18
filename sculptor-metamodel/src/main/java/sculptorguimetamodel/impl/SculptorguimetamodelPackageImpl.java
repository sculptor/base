/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import sculptorguimetamodel.AddTask;
import sculptorguimetamodel.AttributeViewProperty;
import sculptorguimetamodel.BasicTypeEnumViewProperty;
import sculptorguimetamodel.BasicTypeViewProperty;
import sculptorguimetamodel.CreateTask;
import sculptorguimetamodel.DeleteTask;
import sculptorguimetamodel.DerivedReferenceViewProperty;
import sculptorguimetamodel.EnumViewProperty;
import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.ListTask;
import sculptorguimetamodel.ReferenceTarget;
import sculptorguimetamodel.ReferenceViewProperty;
import sculptorguimetamodel.SculptorguimetamodelFactory;
import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.TaskwType;
import sculptorguimetamodel.TmpReferenceHolder;
import sculptorguimetamodel.TmpSubTaskTransitionHolder;
import sculptorguimetamodel.UpdateTask;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.UserTaskGroup;
import sculptorguimetamodel.ViewDataProperty;
import sculptorguimetamodel.ViewTask;

import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SculptorguimetamodelPackageImpl extends EPackageImpl implements SculptorguimetamodelPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass guiApplicationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass guiModuleEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass userTaskEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass createTaskEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass updateTaskEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass viewTaskEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass listTaskEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass deleteTaskEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass subTaskTransitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass viewDataPropertyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tmpReferenceHolderEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tmpSubTaskTransitionHolderEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referenceTargetEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referenceViewPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeViewPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass basicTypeViewPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enumViewPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass basicTypeEnumViewPropertyEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass userTaskGroupEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass derivedReferenceViewPropertyEClass = null;

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass addTaskEClass = null;

                /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private SculptorguimetamodelPackageImpl() {
        super(eNS_URI, SculptorguimetamodelFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link SculptorguimetamodelPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static SculptorguimetamodelPackage init() {
        if (isInited) return (SculptorguimetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(SculptorguimetamodelPackage.eNS_URI);

        // Obtain or create and register package
        SculptorguimetamodelPackageImpl theSculptorguimetamodelPackage = (SculptorguimetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SculptorguimetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SculptorguimetamodelPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        SculptormetamodelPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theSculptorguimetamodelPackage.createPackageContents();

        // Initialize created meta-data
        theSculptorguimetamodelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSculptorguimetamodelPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SculptorguimetamodelPackage.eNS_URI, theSculptorguimetamodelPackage);
        return theSculptorguimetamodelPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getGuiApplication() {
        return guiApplicationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGuiApplication_GuiForApplication() {
        return (EReference)guiApplicationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGuiApplication_Modules() {
        return (EReference)guiApplicationEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getGuiApplication_BasePackage() {
        return (EAttribute)guiApplicationEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getGuiModule() {
        return guiModuleEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGuiModule_UserTasks() {
        return (EReference)guiModuleEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getGuiModule_BasePackage() {
        return (EAttribute)guiModuleEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGuiModule_Application() {
        return (EReference)guiModuleEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGuiModule_For() {
        return (EReference)guiModuleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUserTask() {
        return userTaskEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getUserTask_SubTaskTransitions() {
        return (EReference)userTaskEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getUserTask_For() {
        return (EReference)userTaskEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getUserTask_Abstract() {
        return (EAttribute)userTaskEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getUserTask_Module() {
        return (EReference)userTaskEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getUserTask_TaskType() {
        return (EAttribute)userTaskEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserTask_ViewProperties() {
        return (EReference)userTaskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserTask_ConversationRoot() {
        return (EAttribute)userTaskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUserTask_GapClass() {
        return (EAttribute)userTaskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCreateTask() {
        return createTaskEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCreateTask_CreateDOWith() {
        return (EReference)createTaskEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCreateTask_PopulateDOWith() {
        return (EReference)createTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUpdateTask() {
        return updateTaskEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getUpdateTask_FindDOWith() {
        return (EReference)updateTaskEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getUpdateTask_UpdateDOWith() {
        return (EReference)updateTaskEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUpdateTask_PopulateDOWith() {
        return (EReference)updateTaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getViewTask() {
        return viewTaskEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getViewTask_FindDOWith() {
        return (EReference)viewTaskEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getListTask() {
        return listTaskEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getListTask_SearchDOWith() {
        return (EReference)listTaskEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDeleteTask() {
        return deleteTaskEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDeleteTask_FindDOWith() {
        return (EReference)deleteTaskEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDeleteTask_DeleteDOWith() {
        return (EReference)deleteTaskEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSubTaskTransition() {
        return subTaskTransitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSubTaskTransition_To() {
        return (EReference)subTaskTransitionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSubTaskTransition_ForReference() {
        return (EReference)subTaskTransitionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSubTaskTransition_From() {
        return (EReference)subTaskTransitionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getViewDataProperty() {
        return viewDataPropertyEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getViewDataProperty_UserTask() {
        return (EReference)viewDataPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getViewDataProperty_MessageKey() {
        return (EAttribute)viewDataPropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTmpReferenceHolder() {
        return tmpReferenceHolderEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTmpReferenceHolder_Reference() {
        return (EReference)tmpReferenceHolderEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTmpReferenceHolder_SubTaskTransitionHolders() {
        return (EReference)tmpReferenceHolderEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTmpSubTaskTransitionHolder() {
        return tmpSubTaskTransitionHolderEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTmpSubTaskTransitionHolder_ToTaskType() {
        return (EAttribute)tmpSubTaskTransitionHolderEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTmpSubTaskTransitionHolder_To() {
        return (EReference)tmpSubTaskTransitionHolderEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTmpSubTaskTransitionHolder_ReferenceHoler() {
        return (EReference)tmpSubTaskTransitionHolderEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReferenceTarget() {
        return referenceTargetEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferenceTarget_Reference() {
        return (EReference)referenceTargetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferenceTarget_Target() {
        return (EReference)referenceTargetEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReferenceViewProperty() {
        return referenceViewPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferenceViewProperty_RelatedTransitions() {
        return (EReference)referenceViewPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferenceViewProperty_Reference() {
        return (EReference)referenceViewPropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferenceViewProperty_Target() {
        return (EReference)referenceViewPropertyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReferenceViewProperty_Base() {
        return (EAttribute)referenceViewPropertyEClass.getEStructuralFeatures().get(3);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReferenceViewProperty_PreviewProperties() {
        return (EReference)referenceViewPropertyEClass.getEStructuralFeatures().get(4);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributeViewProperty() {
        return attributeViewPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAttributeViewProperty_Attribute() {
        return (EReference)attributeViewPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBasicTypeViewProperty() {
        return basicTypeViewPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBasicTypeViewProperty_Reference() {
        return (EReference)basicTypeViewPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBasicTypeViewProperty_Attribute() {
        return (EReference)basicTypeViewPropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEnumViewProperty() {
        return enumViewPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEnumViewProperty_Reference() {
        return (EReference)enumViewPropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBasicTypeEnumViewProperty() {
        return basicTypeEnumViewPropertyEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getBasicTypeEnumViewProperty_BasicTypeReference() {
        return (EReference)basicTypeEnumViewPropertyEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUserTaskGroup() {
        return userTaskGroupEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getUserTaskGroup_UserTasks() {
        return (EReference)userTaskGroupEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserTaskGroup_For() {
        return (EReference)userTaskGroupEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUserTaskGroup_Module() {
        return (EReference)userTaskGroupEClass.getEStructuralFeatures().get(2);
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDerivedReferenceViewProperty() {
        return derivedReferenceViewPropertyEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDerivedReferenceViewProperty_DerivedFrom() {
        return (EReference)derivedReferenceViewPropertyEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAddTask() {
        return addTaskEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAddTask_FindDOWith() {
        return (EReference)addTaskEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptorguimetamodelFactory getSculptorguimetamodelFactory() {
        return (SculptorguimetamodelFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        guiApplicationEClass = createEClass(GUI_APPLICATION);
        createEReference(guiApplicationEClass, GUI_APPLICATION__GUI_FOR_APPLICATION);
        createEReference(guiApplicationEClass, GUI_APPLICATION__MODULES);
        createEAttribute(guiApplicationEClass, GUI_APPLICATION__BASE_PACKAGE);

        guiModuleEClass = createEClass(GUI_MODULE);
        createEReference(guiModuleEClass, GUI_MODULE__USER_TASKS);
        createEAttribute(guiModuleEClass, GUI_MODULE__BASE_PACKAGE);
        createEReference(guiModuleEClass, GUI_MODULE__APPLICATION);
        createEReference(guiModuleEClass, GUI_MODULE__FOR);

        userTaskEClass = createEClass(USER_TASK);
        createEReference(userTaskEClass, USER_TASK__SUB_TASK_TRANSITIONS);
        createEReference(userTaskEClass, USER_TASK__FOR);
        createEAttribute(userTaskEClass, USER_TASK__ABSTRACT);
        createEReference(userTaskEClass, USER_TASK__MODULE);
        createEAttribute(userTaskEClass, USER_TASK__TASK_TYPE);
        createEReference(userTaskEClass, USER_TASK__VIEW_PROPERTIES);
        createEAttribute(userTaskEClass, USER_TASK__CONVERSATION_ROOT);
        createEAttribute(userTaskEClass, USER_TASK__GAP_CLASS);

        createTaskEClass = createEClass(CREATE_TASK);
        createEReference(createTaskEClass, CREATE_TASK__CREATE_DO_WITH);
        createEReference(createTaskEClass, CREATE_TASK__POPULATE_DO_WITH);

        updateTaskEClass = createEClass(UPDATE_TASK);
        createEReference(updateTaskEClass, UPDATE_TASK__FIND_DO_WITH);
        createEReference(updateTaskEClass, UPDATE_TASK__UPDATE_DO_WITH);
        createEReference(updateTaskEClass, UPDATE_TASK__POPULATE_DO_WITH);

        viewTaskEClass = createEClass(VIEW_TASK);
        createEReference(viewTaskEClass, VIEW_TASK__FIND_DO_WITH);

        listTaskEClass = createEClass(LIST_TASK);
        createEReference(listTaskEClass, LIST_TASK__SEARCH_DO_WITH);

        deleteTaskEClass = createEClass(DELETE_TASK);
        createEReference(deleteTaskEClass, DELETE_TASK__FIND_DO_WITH);
        createEReference(deleteTaskEClass, DELETE_TASK__DELETE_DO_WITH);

        subTaskTransitionEClass = createEClass(SUB_TASK_TRANSITION);
        createEReference(subTaskTransitionEClass, SUB_TASK_TRANSITION__TO);
        createEReference(subTaskTransitionEClass, SUB_TASK_TRANSITION__FOR_REFERENCE);
        createEReference(subTaskTransitionEClass, SUB_TASK_TRANSITION__FROM);

        viewDataPropertyEClass = createEClass(VIEW_DATA_PROPERTY);
        createEReference(viewDataPropertyEClass, VIEW_DATA_PROPERTY__USER_TASK);
        createEAttribute(viewDataPropertyEClass, VIEW_DATA_PROPERTY__MESSAGE_KEY);

        tmpReferenceHolderEClass = createEClass(TMP_REFERENCE_HOLDER);
        createEReference(tmpReferenceHolderEClass, TMP_REFERENCE_HOLDER__REFERENCE);
        createEReference(tmpReferenceHolderEClass, TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS);

        tmpSubTaskTransitionHolderEClass = createEClass(TMP_SUB_TASK_TRANSITION_HOLDER);
        createEAttribute(tmpSubTaskTransitionHolderEClass, TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE);
        createEReference(tmpSubTaskTransitionHolderEClass, TMP_SUB_TASK_TRANSITION_HOLDER__TO);
        createEReference(tmpSubTaskTransitionHolderEClass, TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER);

        referenceTargetEClass = createEClass(REFERENCE_TARGET);
        createEReference(referenceTargetEClass, REFERENCE_TARGET__REFERENCE);
        createEReference(referenceTargetEClass, REFERENCE_TARGET__TARGET);

        referenceViewPropertyEClass = createEClass(REFERENCE_VIEW_PROPERTY);
        createEReference(referenceViewPropertyEClass, REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS);
        createEReference(referenceViewPropertyEClass, REFERENCE_VIEW_PROPERTY__REFERENCE);
        createEReference(referenceViewPropertyEClass, REFERENCE_VIEW_PROPERTY__TARGET);
        createEAttribute(referenceViewPropertyEClass, REFERENCE_VIEW_PROPERTY__BASE);
        createEReference(referenceViewPropertyEClass, REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES);

        attributeViewPropertyEClass = createEClass(ATTRIBUTE_VIEW_PROPERTY);
        createEReference(attributeViewPropertyEClass, ATTRIBUTE_VIEW_PROPERTY__ATTRIBUTE);

        basicTypeViewPropertyEClass = createEClass(BASIC_TYPE_VIEW_PROPERTY);
        createEReference(basicTypeViewPropertyEClass, BASIC_TYPE_VIEW_PROPERTY__REFERENCE);
        createEReference(basicTypeViewPropertyEClass, BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE);

        enumViewPropertyEClass = createEClass(ENUM_VIEW_PROPERTY);
        createEReference(enumViewPropertyEClass, ENUM_VIEW_PROPERTY__REFERENCE);

        basicTypeEnumViewPropertyEClass = createEClass(BASIC_TYPE_ENUM_VIEW_PROPERTY);
        createEReference(basicTypeEnumViewPropertyEClass, BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE);

        userTaskGroupEClass = createEClass(USER_TASK_GROUP);
        createEReference(userTaskGroupEClass, USER_TASK_GROUP__USER_TASKS);
        createEReference(userTaskGroupEClass, USER_TASK_GROUP__FOR);
        createEReference(userTaskGroupEClass, USER_TASK_GROUP__MODULE);

        derivedReferenceViewPropertyEClass = createEClass(DERIVED_REFERENCE_VIEW_PROPERTY);
        createEReference(derivedReferenceViewPropertyEClass, DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM);

        addTaskEClass = createEClass(ADD_TASK);
        createEReference(addTaskEClass, ADD_TASK__FIND_DO_WITH);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        SculptormetamodelPackage theSculptormetamodelPackage = (SculptormetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(SculptormetamodelPackage.eNS_URI);

        // Add supertypes to classes
        guiApplicationEClass.getESuperTypes().add(theSculptormetamodelPackage.getNamedElement());
        guiModuleEClass.getESuperTypes().add(theSculptormetamodelPackage.getNamedElement());
        userTaskEClass.getESuperTypes().add(theSculptormetamodelPackage.getNamedElement());
        createTaskEClass.getESuperTypes().add(this.getUserTask());
        updateTaskEClass.getESuperTypes().add(this.getUserTask());
        viewTaskEClass.getESuperTypes().add(this.getUserTask());
        listTaskEClass.getESuperTypes().add(this.getUserTask());
        deleteTaskEClass.getESuperTypes().add(this.getUserTask());
        subTaskTransitionEClass.getESuperTypes().add(theSculptormetamodelPackage.getNamedElement());
        viewDataPropertyEClass.getESuperTypes().add(theSculptormetamodelPackage.getNamedElement());
        referenceViewPropertyEClass.getESuperTypes().add(this.getViewDataProperty());
        attributeViewPropertyEClass.getESuperTypes().add(this.getViewDataProperty());
        basicTypeViewPropertyEClass.getESuperTypes().add(this.getViewDataProperty());
        enumViewPropertyEClass.getESuperTypes().add(this.getViewDataProperty());
        basicTypeEnumViewPropertyEClass.getESuperTypes().add(this.getEnumViewProperty());
        derivedReferenceViewPropertyEClass.getESuperTypes().add(this.getReferenceViewProperty());
        addTaskEClass.getESuperTypes().add(this.getUserTask());

        // Initialize classes and features; add operations and parameters
        initEClass(guiApplicationEClass, GuiApplication.class, "GuiApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getGuiApplication_GuiForApplication(), theSculptormetamodelPackage.getApplication(), null, "guiForApplication", null, 1, 1, GuiApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGuiApplication_Modules(), this.getGuiModule(), this.getGuiModule_Application(), "modules", null, 1, -1, GuiApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGuiApplication_BasePackage(), ecorePackage.getEString(), "basePackage", null, 0, 1, GuiApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(guiModuleEClass, GuiModule.class, "GuiModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getGuiModule_UserTasks(), this.getUserTask(), this.getUserTask_Module(), "userTasks", null, 1, -1, GuiModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getGuiModule_BasePackage(), ecorePackage.getEString(), "basePackage", null, 0, 1, GuiModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGuiModule_Application(), this.getGuiApplication(), this.getGuiApplication_Modules(), "application", null, 0, 1, GuiModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGuiModule_For(), theSculptormetamodelPackage.getModule(), null, "for", null, 0, 1, GuiModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(userTaskEClass, UserTask.class, "UserTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUserTask_SubTaskTransitions(), this.getSubTaskTransition(), null, "subTaskTransitions", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUserTask_For(), theSculptormetamodelPackage.getDomainObject(), null, "for", null, 1, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserTask_Abstract(), ecorePackage.getEBooleanObject(), "abstract", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUserTask_Module(), this.getGuiModule(), this.getGuiModule_UserTasks(), "module", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserTask_TaskType(), ecorePackage.getEString(), "taskType", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUserTask_ViewProperties(), this.getViewDataProperty(), this.getViewDataProperty_UserTask(), "viewProperties", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserTask_ConversationRoot(), ecorePackage.getEBoolean(), "conversationRoot", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUserTask_GapClass(), ecorePackage.getEBoolean(), "gapClass", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(createTaskEClass, CreateTask.class, "CreateTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCreateTask_CreateDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "createDOWith", null, 0, 1, CreateTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCreateTask_PopulateDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "populateDOWith", null, 0, 1, CreateTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(updateTaskEClass, UpdateTask.class, "UpdateTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUpdateTask_FindDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "findDOWith", null, 0, 1, UpdateTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUpdateTask_UpdateDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "updateDOWith", null, 0, 1, UpdateTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUpdateTask_PopulateDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "populateDOWith", null, 0, 1, UpdateTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(viewTaskEClass, ViewTask.class, "ViewTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getViewTask_FindDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "findDOWith", null, 0, 1, ViewTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(listTaskEClass, ListTask.class, "ListTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getListTask_SearchDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "searchDOWith", null, 0, 1, ListTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(deleteTaskEClass, DeleteTask.class, "DeleteTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDeleteTask_FindDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "findDOWith", null, 0, 1, DeleteTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDeleteTask_DeleteDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "deleteDOWith", null, 0, 1, DeleteTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(subTaskTransitionEClass, SubTaskTransition.class, "SubTaskTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSubTaskTransition_To(), this.getUserTask(), null, "to", null, 0, 1, SubTaskTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSubTaskTransition_ForReference(), theSculptormetamodelPackage.getReference(), null, "forReference", null, 1, 1, SubTaskTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSubTaskTransition_From(), this.getUserTask(), null, "from", null, 0, 1, SubTaskTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(viewDataPropertyEClass, ViewDataProperty.class, "ViewDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getViewDataProperty_UserTask(), this.getUserTask(), this.getUserTask_ViewProperties(), "userTask", null, 0, 1, ViewDataProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getViewDataProperty_MessageKey(), ecorePackage.getEString(), "messageKey", null, 0, 1, ViewDataProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tmpReferenceHolderEClass, TmpReferenceHolder.class, "TmpReferenceHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTmpReferenceHolder_Reference(), theSculptormetamodelPackage.getReference(), null, "reference", null, 0, 1, TmpReferenceHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTmpReferenceHolder_SubTaskTransitionHolders(), this.getTmpSubTaskTransitionHolder(), this.getTmpSubTaskTransitionHolder_ReferenceHoler(), "subTaskTransitionHolders", null, 0, -1, TmpReferenceHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tmpSubTaskTransitionHolderEClass, TmpSubTaskTransitionHolder.class, "TmpSubTaskTransitionHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTmpSubTaskTransitionHolder_ToTaskType(), ecorePackage.getEString(), "toTaskType", null, 0, 1, TmpSubTaskTransitionHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTmpSubTaskTransitionHolder_To(), theSculptormetamodelPackage.getDomainObject(), null, "to", null, 0, 1, TmpSubTaskTransitionHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTmpSubTaskTransitionHolder_ReferenceHoler(), this.getTmpReferenceHolder(), this.getTmpReferenceHolder_SubTaskTransitionHolders(), "referenceHoler", null, 1, 1, TmpSubTaskTransitionHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referenceTargetEClass, ReferenceTarget.class, "ReferenceTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReferenceTarget_Reference(), theSculptormetamodelPackage.getReference(), null, "reference", null, 0, 1, ReferenceTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferenceTarget_Target(), theSculptormetamodelPackage.getDomainObject(), null, "target", null, 0, 1, ReferenceTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referenceViewPropertyEClass, ReferenceViewProperty.class, "ReferenceViewProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReferenceViewProperty_RelatedTransitions(), this.getSubTaskTransition(), null, "relatedTransitions", null, 0, -1, ReferenceViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferenceViewProperty_Reference(), theSculptormetamodelPackage.getReference(), null, "reference", null, 0, 1, ReferenceViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferenceViewProperty_Target(), theSculptormetamodelPackage.getDomainObject(), null, "target", null, 0, 1, ReferenceViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferenceViewProperty_Base(), ecorePackage.getEBoolean(), "base", null, 0, 1, ReferenceViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReferenceViewProperty_PreviewProperties(), this.getViewDataProperty(), null, "previewProperties", null, 0, -1, ReferenceViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeViewPropertyEClass, AttributeViewProperty.class, "AttributeViewProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAttributeViewProperty_Attribute(), theSculptormetamodelPackage.getAttribute(), null, "attribute", null, 0, 1, AttributeViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(basicTypeViewPropertyEClass, BasicTypeViewProperty.class, "BasicTypeViewProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBasicTypeViewProperty_Reference(), theSculptormetamodelPackage.getReference(), null, "reference", null, 0, 1, BasicTypeViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getBasicTypeViewProperty_Attribute(), theSculptormetamodelPackage.getAttribute(), null, "attribute", null, 0, 1, BasicTypeViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumViewPropertyEClass, EnumViewProperty.class, "EnumViewProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEnumViewProperty_Reference(), theSculptormetamodelPackage.getReference(), null, "reference", null, 0, 1, EnumViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(basicTypeEnumViewPropertyEClass, BasicTypeEnumViewProperty.class, "BasicTypeEnumViewProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBasicTypeEnumViewProperty_BasicTypeReference(), theSculptormetamodelPackage.getReference(), null, "basicTypeReference", null, 0, 1, BasicTypeEnumViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(userTaskGroupEClass, UserTaskGroup.class, "UserTaskGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUserTaskGroup_UserTasks(), this.getUserTask(), null, "userTasks", null, 0, -1, UserTaskGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUserTaskGroup_For(), theSculptormetamodelPackage.getDomainObject(), null, "for", null, 0, 1, UserTaskGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUserTaskGroup_Module(), this.getGuiModule(), null, "module", null, 0, 1, UserTaskGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(derivedReferenceViewPropertyEClass, DerivedReferenceViewProperty.class, "DerivedReferenceViewProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDerivedReferenceViewProperty_DerivedFrom(), this.getReferenceViewProperty(), null, "derivedFrom", null, 1, 1, DerivedReferenceViewProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(addTaskEClass, AddTask.class, "AddTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAddTask_FindDOWith(), theSculptormetamodelPackage.getServiceOperation(), null, "findDOWith", null, 0, 1, AddTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //SculptorguimetamodelPackageImpl
