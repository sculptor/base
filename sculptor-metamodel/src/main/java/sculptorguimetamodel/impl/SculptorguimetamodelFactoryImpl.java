/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sculptorguimetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SculptorguimetamodelFactoryImpl extends EFactoryImpl implements SculptorguimetamodelFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SculptorguimetamodelFactory init() {
        try {
            SculptorguimetamodelFactory theSculptorguimetamodelFactory = (SculptorguimetamodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.fornax-platform.org/sculptorgui"); 
            if (theSculptorguimetamodelFactory != null) {
                return theSculptorguimetamodelFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SculptorguimetamodelFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptorguimetamodelFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SculptorguimetamodelPackage.GUI_APPLICATION: return createGuiApplication();
            case SculptorguimetamodelPackage.GUI_MODULE: return createGuiModule();
            case SculptorguimetamodelPackage.USER_TASK: return createUserTask();
            case SculptorguimetamodelPackage.CREATE_TASK: return createCreateTask();
            case SculptorguimetamodelPackage.UPDATE_TASK: return createUpdateTask();
            case SculptorguimetamodelPackage.VIEW_TASK: return createViewTask();
            case SculptorguimetamodelPackage.LIST_TASK: return createListTask();
            case SculptorguimetamodelPackage.DELETE_TASK: return createDeleteTask();
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION: return createSubTaskTransition();
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY: return createViewDataProperty();
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER: return createTmpReferenceHolder();
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER: return createTmpSubTaskTransitionHolder();
            case SculptorguimetamodelPackage.REFERENCE_TARGET: return createReferenceTarget();
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY: return createReferenceViewProperty();
            case SculptorguimetamodelPackage.ATTRIBUTE_VIEW_PROPERTY: return createAttributeViewProperty();
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY: return createBasicTypeViewProperty();
            case SculptorguimetamodelPackage.ENUM_VIEW_PROPERTY: return createEnumViewProperty();
            case SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY: return createBasicTypeEnumViewProperty();
            case SculptorguimetamodelPackage.USER_TASK_GROUP: return createUserTaskGroup();
            case SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY: return createDerivedReferenceViewProperty();
            case SculptorguimetamodelPackage.ADD_TASK: return createAddTask();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GuiApplication createGuiApplication() {
        GuiApplicationImpl guiApplication = new GuiApplicationImpl();
        return guiApplication;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GuiModule createGuiModule() {
        GuiModuleImpl guiModule = new GuiModuleImpl();
        return guiModule;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UserTask createUserTask() {
        UserTaskImpl userTask = new UserTaskImpl();
        return userTask;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CreateTask createCreateTask() {
        CreateTaskImpl createTask = new CreateTaskImpl();
        return createTask;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UpdateTask createUpdateTask() {
        UpdateTaskImpl updateTask = new UpdateTaskImpl();
        return updateTask;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ViewTask createViewTask() {
        ViewTaskImpl viewTask = new ViewTaskImpl();
        return viewTask;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ListTask createListTask() {
        ListTaskImpl listTask = new ListTaskImpl();
        return listTask;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DeleteTask createDeleteTask() {
        DeleteTaskImpl deleteTask = new DeleteTaskImpl();
        return deleteTask;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SubTaskTransition createSubTaskTransition() {
        SubTaskTransitionImpl subTaskTransition = new SubTaskTransitionImpl();
        return subTaskTransition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ViewDataProperty createViewDataProperty() {
        ViewDataPropertyImpl viewDataProperty = new ViewDataPropertyImpl();
        return viewDataProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TmpReferenceHolder createTmpReferenceHolder() {
        TmpReferenceHolderImpl tmpReferenceHolder = new TmpReferenceHolderImpl();
        return tmpReferenceHolder;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TmpSubTaskTransitionHolder createTmpSubTaskTransitionHolder() {
        TmpSubTaskTransitionHolderImpl tmpSubTaskTransitionHolder = new TmpSubTaskTransitionHolderImpl();
        return tmpSubTaskTransitionHolder;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferenceTarget createReferenceTarget() {
        ReferenceTargetImpl referenceTarget = new ReferenceTargetImpl();
        return referenceTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferenceViewProperty createReferenceViewProperty() {
        ReferenceViewPropertyImpl referenceViewProperty = new ReferenceViewPropertyImpl();
        return referenceViewProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeViewProperty createAttributeViewProperty() {
        AttributeViewPropertyImpl attributeViewProperty = new AttributeViewPropertyImpl();
        return attributeViewProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BasicTypeViewProperty createBasicTypeViewProperty() {
        BasicTypeViewPropertyImpl basicTypeViewProperty = new BasicTypeViewPropertyImpl();
        return basicTypeViewProperty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumViewProperty createEnumViewProperty() {
        EnumViewPropertyImpl enumViewProperty = new EnumViewPropertyImpl();
        return enumViewProperty;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BasicTypeEnumViewProperty createBasicTypeEnumViewProperty() {
        BasicTypeEnumViewPropertyImpl basicTypeEnumViewProperty = new BasicTypeEnumViewPropertyImpl();
        return basicTypeEnumViewProperty;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UserTaskGroup createUserTaskGroup() {
        UserTaskGroupImpl userTaskGroup = new UserTaskGroupImpl();
        return userTaskGroup;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DerivedReferenceViewProperty createDerivedReferenceViewProperty() {
        DerivedReferenceViewPropertyImpl derivedReferenceViewProperty = new DerivedReferenceViewPropertyImpl();
        return derivedReferenceViewProperty;
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AddTask createAddTask() {
        AddTaskImpl addTask = new AddTaskImpl();
        return addTask;
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptorguimetamodelPackage getSculptorguimetamodelPackage() {
        return (SculptorguimetamodelPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	public static SculptorguimetamodelPackage getPackage() {
        return SculptorguimetamodelPackage.eINSTANCE;
    }

} //SculptorguimetamodelFactoryImpl
