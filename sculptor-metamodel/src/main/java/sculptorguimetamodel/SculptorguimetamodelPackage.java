/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see sculptorguimetamodel.SculptorguimetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface SculptorguimetamodelPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "sculptorguimetamodel";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.fornax-platform.org/sculptorgui";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "sc";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	SculptorguimetamodelPackage eINSTANCE = sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl.init();

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.GuiApplicationImpl <em>Gui Application</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.GuiApplicationImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getGuiApplication()
     * @generated
     */
	int GUI_APPLICATION = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_APPLICATION__NAME = SculptormetamodelPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_APPLICATION__DOC = SculptormetamodelPackage.NAMED_ELEMENT__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUI_APPLICATION__HINT = SculptormetamodelPackage.NAMED_ELEMENT__HINT;

    /**
     * The feature id for the '<em><b>Gui For Application</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_APPLICATION__GUI_FOR_APPLICATION = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_APPLICATION__MODULES = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_APPLICATION__BASE_PACKAGE = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Gui Application</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_APPLICATION_FEATURE_COUNT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.GuiModuleImpl <em>Gui Module</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.GuiModuleImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getGuiModule()
     * @generated
     */
	int GUI_MODULE = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_MODULE__NAME = SculptormetamodelPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_MODULE__DOC = SculptormetamodelPackage.NAMED_ELEMENT__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUI_MODULE__HINT = SculptormetamodelPackage.NAMED_ELEMENT__HINT;

    /**
     * The feature id for the '<em><b>User Tasks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_MODULE__USER_TASKS = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_MODULE__BASE_PACKAGE = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Application</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_MODULE__APPLICATION = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GUI_MODULE__FOR = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Gui Module</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GUI_MODULE_FEATURE_COUNT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.UserTaskImpl <em>User Task</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.UserTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getUserTask()
     * @generated
     */
	int USER_TASK = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__NAME = SculptormetamodelPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__DOC = SculptormetamodelPackage.NAMED_ELEMENT__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_TASK__HINT = SculptormetamodelPackage.NAMED_ELEMENT__HINT;

    /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__SUB_TASK_TRANSITIONS = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__FOR = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__ABSTRACT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__MODULE = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK__TASK_TYPE = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_TASK__VIEW_PROPERTIES = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_TASK__CONVERSATION_ROOT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_TASK__GAP_CLASS = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>User Task</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK_FEATURE_COUNT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.CreateTaskImpl <em>Create Task</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.CreateTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getCreateTask()
     * @generated
     */
	int CREATE_TASK = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__NAME = USER_TASK__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__DOC = USER_TASK__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_TASK__HINT = USER_TASK__HINT;

    /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__SUB_TASK_TRANSITIONS = USER_TASK__SUB_TASK_TRANSITIONS;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__FOR = USER_TASK__FOR;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__ABSTRACT = USER_TASK__ABSTRACT;

	/**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__MODULE = USER_TASK__MODULE;

	/**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__TASK_TYPE = USER_TASK__TASK_TYPE;

	/**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_TASK__VIEW_PROPERTIES = USER_TASK__VIEW_PROPERTIES;

    /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_TASK__CONVERSATION_ROOT = USER_TASK__CONVERSATION_ROOT;

    /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_TASK__GAP_CLASS = USER_TASK__GAP_CLASS;

    /**
     * The feature id for the '<em><b>Create DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK__CREATE_DO_WITH = USER_TASK_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Populate DO With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_TASK__POPULATE_DO_WITH = USER_TASK_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Create Task</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CREATE_TASK_FEATURE_COUNT = USER_TASK_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.UpdateTaskImpl <em>Update Task</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.UpdateTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getUpdateTask()
     * @generated
     */
	int UPDATE_TASK = 4;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__NAME = USER_TASK__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__DOC = USER_TASK__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TASK__HINT = USER_TASK__HINT;

    /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__SUB_TASK_TRANSITIONS = USER_TASK__SUB_TASK_TRANSITIONS;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__FOR = USER_TASK__FOR;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__ABSTRACT = USER_TASK__ABSTRACT;

	/**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__MODULE = USER_TASK__MODULE;

	/**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__TASK_TYPE = USER_TASK__TASK_TYPE;

	/**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TASK__VIEW_PROPERTIES = USER_TASK__VIEW_PROPERTIES;

    /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TASK__CONVERSATION_ROOT = USER_TASK__CONVERSATION_ROOT;

    /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TASK__GAP_CLASS = USER_TASK__GAP_CLASS;

    /**
     * The feature id for the '<em><b>Find DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__FIND_DO_WITH = USER_TASK_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Update DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK__UPDATE_DO_WITH = USER_TASK_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Populate DO With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TASK__POPULATE_DO_WITH = USER_TASK_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Update Task</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UPDATE_TASK_FEATURE_COUNT = USER_TASK_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.ViewTaskImpl <em>View Task</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.ViewTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getViewTask()
     * @generated
     */
	int VIEW_TASK = 5;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__NAME = USER_TASK__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__DOC = USER_TASK__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_TASK__HINT = USER_TASK__HINT;

    /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__SUB_TASK_TRANSITIONS = USER_TASK__SUB_TASK_TRANSITIONS;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__FOR = USER_TASK__FOR;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__ABSTRACT = USER_TASK__ABSTRACT;

	/**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__MODULE = USER_TASK__MODULE;

	/**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__TASK_TYPE = USER_TASK__TASK_TYPE;

	/**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_TASK__VIEW_PROPERTIES = USER_TASK__VIEW_PROPERTIES;

    /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_TASK__CONVERSATION_ROOT = USER_TASK__CONVERSATION_ROOT;

    /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_TASK__GAP_CLASS = USER_TASK__GAP_CLASS;

    /**
     * The feature id for the '<em><b>Find DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK__FIND_DO_WITH = USER_TASK_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>View Task</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_TASK_FEATURE_COUNT = USER_TASK_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.ListTaskImpl <em>List Task</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.ListTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getListTask()
     * @generated
     */
	int LIST_TASK = 6;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__NAME = USER_TASK__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__DOC = USER_TASK__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_TASK__HINT = USER_TASK__HINT;

    /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__SUB_TASK_TRANSITIONS = USER_TASK__SUB_TASK_TRANSITIONS;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__FOR = USER_TASK__FOR;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__ABSTRACT = USER_TASK__ABSTRACT;

	/**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__MODULE = USER_TASK__MODULE;

	/**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__TASK_TYPE = USER_TASK__TASK_TYPE;

	/**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_TASK__VIEW_PROPERTIES = USER_TASK__VIEW_PROPERTIES;

    /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_TASK__CONVERSATION_ROOT = USER_TASK__CONVERSATION_ROOT;

    /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_TASK__GAP_CLASS = USER_TASK__GAP_CLASS;

    /**
     * The feature id for the '<em><b>Search DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK__SEARCH_DO_WITH = USER_TASK_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>List Task</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LIST_TASK_FEATURE_COUNT = USER_TASK_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.DeleteTaskImpl <em>Delete Task</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.DeleteTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getDeleteTask()
     * @generated
     */
	int DELETE_TASK = 7;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__NAME = USER_TASK__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__DOC = USER_TASK__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_TASK__HINT = USER_TASK__HINT;

    /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__SUB_TASK_TRANSITIONS = USER_TASK__SUB_TASK_TRANSITIONS;

	/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__FOR = USER_TASK__FOR;

	/**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__ABSTRACT = USER_TASK__ABSTRACT;

	/**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__MODULE = USER_TASK__MODULE;

	/**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__TASK_TYPE = USER_TASK__TASK_TYPE;

	/**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_TASK__VIEW_PROPERTIES = USER_TASK__VIEW_PROPERTIES;

    /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_TASK__CONVERSATION_ROOT = USER_TASK__CONVERSATION_ROOT;

    /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_TASK__GAP_CLASS = USER_TASK__GAP_CLASS;

    /**
     * The feature id for the '<em><b>Find DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__FIND_DO_WITH = USER_TASK_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Delete DO With</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK__DELETE_DO_WITH = USER_TASK_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Delete Task</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELETE_TASK_FEATURE_COUNT = USER_TASK_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.SubTaskTransitionImpl <em>Sub Task Transition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.SubTaskTransitionImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getSubTaskTransition()
     * @generated
     */
	int SUB_TASK_TRANSITION = 8;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUB_TASK_TRANSITION__NAME = SculptormetamodelPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUB_TASK_TRANSITION__DOC = SculptormetamodelPackage.NAMED_ELEMENT__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_TASK_TRANSITION__HINT = SculptormetamodelPackage.NAMED_ELEMENT__HINT;

    /**
     * The feature id for the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUB_TASK_TRANSITION__TO = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>For Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUB_TASK_TRANSITION__FOR_REFERENCE = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>From</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUB_TASK_TRANSITION__FROM = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Sub Task Transition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUB_TASK_TRANSITION_FEATURE_COUNT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.ViewDataPropertyImpl <em>View Data Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.ViewDataPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getViewDataProperty()
     * @generated
     */
	int VIEW_DATA_PROPERTY = 9;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_DATA_PROPERTY__NAME = SculptormetamodelPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_DATA_PROPERTY__DOC = SculptormetamodelPackage.NAMED_ELEMENT__DOC;

	/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_DATA_PROPERTY__HINT = SculptormetamodelPackage.NAMED_ELEMENT__HINT;

    /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_DATA_PROPERTY__USER_TASK = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_DATA_PROPERTY__MESSAGE_KEY = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>View Data Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VIEW_DATA_PROPERTY_FEATURE_COUNT = SculptormetamodelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.TmpReferenceHolderImpl <em>Tmp Reference Holder</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.TmpReferenceHolderImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getTmpReferenceHolder()
     * @generated
     */
	int TMP_REFERENCE_HOLDER = 10;

	/**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_REFERENCE_HOLDER__REFERENCE = 0;

	/**
     * The feature id for the '<em><b>Sub Task Transition Holders</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS = 1;

	/**
     * The number of structural features of the '<em>Tmp Reference Holder</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_REFERENCE_HOLDER_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl <em>Tmp Sub Task Transition Holder</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getTmpSubTaskTransitionHolder()
     * @generated
     */
	int TMP_SUB_TASK_TRANSITION_HOLDER = 11;

	/**
     * The feature id for the '<em><b>To Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE = 0;

	/**
     * The feature id for the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_SUB_TASK_TRANSITION_HOLDER__TO = 1;

	/**
     * The feature id for the '<em><b>Reference Holer</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER = 2;

	/**
     * The number of structural features of the '<em>Tmp Sub Task Transition Holder</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TMP_SUB_TASK_TRANSITION_HOLDER_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.ReferenceTargetImpl <em>Reference Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.ReferenceTargetImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getReferenceTarget()
     * @generated
     */
    int REFERENCE_TARGET = 12;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_TARGET__REFERENCE = 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_TARGET__TARGET = 1;

    /**
     * The number of structural features of the '<em>Reference Target</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_TARGET_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl <em>Reference View Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.ReferenceViewPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getReferenceViewProperty()
     * @generated
     */
    int REFERENCE_VIEW_PROPERTY = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__NAME = VIEW_DATA_PROPERTY__NAME;

    /**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__DOC = VIEW_DATA_PROPERTY__DOC;

    /**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__HINT = VIEW_DATA_PROPERTY__HINT;

    /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__USER_TASK = VIEW_DATA_PROPERTY__USER_TASK;

    /**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__MESSAGE_KEY = VIEW_DATA_PROPERTY__MESSAGE_KEY;

    /**
     * The feature id for the '<em><b>Related Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS = VIEW_DATA_PROPERTY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__REFERENCE = VIEW_DATA_PROPERTY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__TARGET = VIEW_DATA_PROPERTY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Base</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REFERENCE_VIEW_PROPERTY__BASE = VIEW_DATA_PROPERTY_FEATURE_COUNT + 3;

				/**
     * The feature id for the '<em><b>Preview Properties</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES = VIEW_DATA_PROPERTY_FEATURE_COUNT + 4;

                /**
     * The number of structural features of the '<em>Reference View Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_VIEW_PROPERTY_FEATURE_COUNT = VIEW_DATA_PROPERTY_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link sculptorguimetamodel.impl.AttributeViewPropertyImpl <em>Attribute View Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.AttributeViewPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getAttributeViewProperty()
     * @generated
     */
    int ATTRIBUTE_VIEW_PROPERTY = 14;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY__NAME = VIEW_DATA_PROPERTY__NAME;

    /**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY__DOC = VIEW_DATA_PROPERTY__DOC;

    /**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY__HINT = VIEW_DATA_PROPERTY__HINT;

    /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY__USER_TASK = VIEW_DATA_PROPERTY__USER_TASK;

    /**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY__MESSAGE_KEY = VIEW_DATA_PROPERTY__MESSAGE_KEY;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY__ATTRIBUTE = VIEW_DATA_PROPERTY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute View Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VIEW_PROPERTY_FEATURE_COUNT = VIEW_DATA_PROPERTY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link sculptorguimetamodel.impl.BasicTypeViewPropertyImpl <em>Basic Type View Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.BasicTypeViewPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getBasicTypeViewProperty()
     * @generated
     */
    int BASIC_TYPE_VIEW_PROPERTY = 15;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__NAME = VIEW_DATA_PROPERTY__NAME;

    /**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__DOC = VIEW_DATA_PROPERTY__DOC;

    /**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__HINT = VIEW_DATA_PROPERTY__HINT;

    /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__USER_TASK = VIEW_DATA_PROPERTY__USER_TASK;

    /**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__MESSAGE_KEY = VIEW_DATA_PROPERTY__MESSAGE_KEY;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__REFERENCE = VIEW_DATA_PROPERTY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE = VIEW_DATA_PROPERTY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Basic Type View Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_VIEW_PROPERTY_FEATURE_COUNT = VIEW_DATA_PROPERTY_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link sculptorguimetamodel.impl.EnumViewPropertyImpl <em>Enum View Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.EnumViewPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getEnumViewProperty()
     * @generated
     */
    int ENUM_VIEW_PROPERTY = 16;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY__NAME = VIEW_DATA_PROPERTY__NAME;

    /**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY__DOC = VIEW_DATA_PROPERTY__DOC;

    /**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY__HINT = VIEW_DATA_PROPERTY__HINT;

    /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY__USER_TASK = VIEW_DATA_PROPERTY__USER_TASK;

    /**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY__MESSAGE_KEY = VIEW_DATA_PROPERTY__MESSAGE_KEY;

    /**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY__REFERENCE = VIEW_DATA_PROPERTY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Enum View Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VIEW_PROPERTY_FEATURE_COUNT = VIEW_DATA_PROPERTY_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link sculptorguimetamodel.impl.BasicTypeEnumViewPropertyImpl <em>Basic Type Enum View Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.BasicTypeEnumViewPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getBasicTypeEnumViewProperty()
     * @generated
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY = 17;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY__NAME = ENUM_VIEW_PROPERTY__NAME;

				/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY__DOC = ENUM_VIEW_PROPERTY__DOC;

				/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_ENUM_VIEW_PROPERTY__HINT = ENUM_VIEW_PROPERTY__HINT;

                /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY__USER_TASK = ENUM_VIEW_PROPERTY__USER_TASK;

				/**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BASIC_TYPE_ENUM_VIEW_PROPERTY__MESSAGE_KEY = ENUM_VIEW_PROPERTY__MESSAGE_KEY;

                /**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY__REFERENCE = ENUM_VIEW_PROPERTY__REFERENCE;

				/**
     * The feature id for the '<em><b>Basic Type Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE = ENUM_VIEW_PROPERTY_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Basic Type Enum View Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BASIC_TYPE_ENUM_VIEW_PROPERTY_FEATURE_COUNT = ENUM_VIEW_PROPERTY_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.UserTaskGroupImpl <em>User Task Group</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.UserTaskGroupImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getUserTaskGroup()
     * @generated
     */
	int USER_TASK_GROUP = 18;

				/**
     * The feature id for the '<em><b>User Tasks</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK_GROUP__USER_TASKS = 0;

				/**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_TASK_GROUP__FOR = 1;

                /**
     * The feature id for the '<em><b>Module</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_TASK_GROUP__MODULE = 2;

                /**
     * The number of structural features of the '<em>User Task Group</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int USER_TASK_GROUP_FEATURE_COUNT = 3;

				/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.DerivedReferenceViewPropertyImpl <em>Derived Reference View Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.DerivedReferenceViewPropertyImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getDerivedReferenceViewProperty()
     * @generated
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY = 19;

				/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__NAME = REFERENCE_VIEW_PROPERTY__NAME;

				/**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__DOC = REFERENCE_VIEW_PROPERTY__DOC;

				/**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DERIVED_REFERENCE_VIEW_PROPERTY__HINT = REFERENCE_VIEW_PROPERTY__HINT;

                /**
     * The feature id for the '<em><b>User Task</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__USER_TASK = REFERENCE_VIEW_PROPERTY__USER_TASK;

				/**
     * The feature id for the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DERIVED_REFERENCE_VIEW_PROPERTY__MESSAGE_KEY = REFERENCE_VIEW_PROPERTY__MESSAGE_KEY;

                /**
     * The feature id for the '<em><b>Related Transitions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS = REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS;

				/**
     * The feature id for the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__REFERENCE = REFERENCE_VIEW_PROPERTY__REFERENCE;

				/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__TARGET = REFERENCE_VIEW_PROPERTY__TARGET;

				/**
     * The feature id for the '<em><b>Base</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__BASE = REFERENCE_VIEW_PROPERTY__BASE;

				/**
     * The feature id for the '<em><b>Preview Properties</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DERIVED_REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES = REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES;

                /**
     * The feature id for the '<em><b>Derived From</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM = REFERENCE_VIEW_PROPERTY_FEATURE_COUNT + 0;

				/**
     * The number of structural features of the '<em>Derived Reference View Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DERIVED_REFERENCE_VIEW_PROPERTY_FEATURE_COUNT = REFERENCE_VIEW_PROPERTY_FEATURE_COUNT + 1;

				/**
     * The meta object id for the '{@link sculptorguimetamodel.impl.AddTaskImpl <em>Add Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sculptorguimetamodel.impl.AddTaskImpl
     * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getAddTask()
     * @generated
     */
    int ADD_TASK = 20;

                /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__NAME = USER_TASK__NAME;

                /**
     * The feature id for the '<em><b>Doc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__DOC = USER_TASK__DOC;

                /**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__HINT = USER_TASK__HINT;

                /**
     * The feature id for the '<em><b>Sub Task Transitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__SUB_TASK_TRANSITIONS = USER_TASK__SUB_TASK_TRANSITIONS;

                /**
     * The feature id for the '<em><b>For</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__FOR = USER_TASK__FOR;

                /**
     * The feature id for the '<em><b>Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__ABSTRACT = USER_TASK__ABSTRACT;

                /**
     * The feature id for the '<em><b>Module</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__MODULE = USER_TASK__MODULE;

                /**
     * The feature id for the '<em><b>Task Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__TASK_TYPE = USER_TASK__TASK_TYPE;

                /**
     * The feature id for the '<em><b>View Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__VIEW_PROPERTIES = USER_TASK__VIEW_PROPERTIES;

                /**
     * The feature id for the '<em><b>Conversation Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__CONVERSATION_ROOT = USER_TASK__CONVERSATION_ROOT;

                /**
     * The feature id for the '<em><b>Gap Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__GAP_CLASS = USER_TASK__GAP_CLASS;

                /**
     * The feature id for the '<em><b>Find DO With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK__FIND_DO_WITH = USER_TASK_FEATURE_COUNT + 0;

                /**
     * The number of structural features of the '<em>Add Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ADD_TASK_FEATURE_COUNT = USER_TASK_FEATURE_COUNT + 1;

                /**
     * Returns the meta object for class '{@link sculptorguimetamodel.GuiApplication <em>Gui Application</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gui Application</em>'.
     * @see sculptorguimetamodel.GuiApplication
     * @generated
     */
	EClass getGuiApplication();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.GuiApplication#getGuiForApplication <em>Gui For Application</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Gui For Application</em>'.
     * @see sculptorguimetamodel.GuiApplication#getGuiForApplication()
     * @see #getGuiApplication()
     * @generated
     */
	EReference getGuiApplication_GuiForApplication();

	/**
     * Returns the meta object for the containment reference list '{@link sculptorguimetamodel.GuiApplication#getModules <em>Modules</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Modules</em>'.
     * @see sculptorguimetamodel.GuiApplication#getModules()
     * @see #getGuiApplication()
     * @generated
     */
	EReference getGuiApplication_Modules();

	/**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.GuiApplication#getBasePackage <em>Base Package</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Package</em>'.
     * @see sculptorguimetamodel.GuiApplication#getBasePackage()
     * @see #getGuiApplication()
     * @generated
     */
	EAttribute getGuiApplication_BasePackage();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.GuiModule <em>Gui Module</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Gui Module</em>'.
     * @see sculptorguimetamodel.GuiModule
     * @generated
     */
	EClass getGuiModule();

	/**
     * Returns the meta object for the containment reference list '{@link sculptorguimetamodel.GuiModule#getUserTasks <em>User Tasks</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>User Tasks</em>'.
     * @see sculptorguimetamodel.GuiModule#getUserTasks()
     * @see #getGuiModule()
     * @generated
     */
	EReference getGuiModule_UserTasks();

	/**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.GuiModule#getBasePackage <em>Base Package</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Package</em>'.
     * @see sculptorguimetamodel.GuiModule#getBasePackage()
     * @see #getGuiModule()
     * @generated
     */
	EAttribute getGuiModule_BasePackage();

	/**
     * Returns the meta object for the container reference '{@link sculptorguimetamodel.GuiModule#getApplication <em>Application</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Application</em>'.
     * @see sculptorguimetamodel.GuiModule#getApplication()
     * @see #getGuiModule()
     * @generated
     */
	EReference getGuiModule_Application();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.GuiModule#getFor <em>For</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>For</em>'.
     * @see sculptorguimetamodel.GuiModule#getFor()
     * @see #getGuiModule()
     * @generated
     */
    EReference getGuiModule_For();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.UserTask <em>User Task</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Task</em>'.
     * @see sculptorguimetamodel.UserTask
     * @generated
     */
	EClass getUserTask();

	/**
     * Returns the meta object for the containment reference list '{@link sculptorguimetamodel.UserTask#getSubTaskTransitions <em>Sub Task Transitions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Task Transitions</em>'.
     * @see sculptorguimetamodel.UserTask#getSubTaskTransitions()
     * @see #getUserTask()
     * @generated
     */
	EReference getUserTask_SubTaskTransitions();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.UserTask#getFor <em>For</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>For</em>'.
     * @see sculptorguimetamodel.UserTask#getFor()
     * @see #getUserTask()
     * @generated
     */
	EReference getUserTask_For();

	/**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.UserTask#getAbstract <em>Abstract</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Abstract</em>'.
     * @see sculptorguimetamodel.UserTask#getAbstract()
     * @see #getUserTask()
     * @generated
     */
	EAttribute getUserTask_Abstract();

	/**
     * Returns the meta object for the container reference '{@link sculptorguimetamodel.UserTask#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Module</em>'.
     * @see sculptorguimetamodel.UserTask#getModule()
     * @see #getUserTask()
     * @generated
     */
	EReference getUserTask_Module();

	/**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.UserTask#getTaskType <em>Task Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Task Type</em>'.
     * @see sculptorguimetamodel.UserTask#getTaskType()
     * @see #getUserTask()
     * @generated
     */
	EAttribute getUserTask_TaskType();

	/**
     * Returns the meta object for the containment reference list '{@link sculptorguimetamodel.UserTask#getViewProperties <em>View Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>View Properties</em>'.
     * @see sculptorguimetamodel.UserTask#getViewProperties()
     * @see #getUserTask()
     * @generated
     */
    EReference getUserTask_ViewProperties();

    /**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.UserTask#isConversationRoot <em>Conversation Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Conversation Root</em>'.
     * @see sculptorguimetamodel.UserTask#isConversationRoot()
     * @see #getUserTask()
     * @generated
     */
    EAttribute getUserTask_ConversationRoot();

    /**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.UserTask#isGapClass <em>Gap Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Gap Class</em>'.
     * @see sculptorguimetamodel.UserTask#isGapClass()
     * @see #getUserTask()
     * @generated
     */
    EAttribute getUserTask_GapClass();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.CreateTask <em>Create Task</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Create Task</em>'.
     * @see sculptorguimetamodel.CreateTask
     * @generated
     */
	EClass getCreateTask();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.CreateTask#getCreateDOWith <em>Create DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Create DO With</em>'.
     * @see sculptorguimetamodel.CreateTask#getCreateDOWith()
     * @see #getCreateTask()
     * @generated
     */
	EReference getCreateTask_CreateDOWith();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.CreateTask#getPopulateDOWith <em>Populate DO With</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Populate DO With</em>'.
     * @see sculptorguimetamodel.CreateTask#getPopulateDOWith()
     * @see #getCreateTask()
     * @generated
     */
    EReference getCreateTask_PopulateDOWith();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.UpdateTask <em>Update Task</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Task</em>'.
     * @see sculptorguimetamodel.UpdateTask
     * @generated
     */
	EClass getUpdateTask();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.UpdateTask#getFindDOWith <em>Find DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Find DO With</em>'.
     * @see sculptorguimetamodel.UpdateTask#getFindDOWith()
     * @see #getUpdateTask()
     * @generated
     */
	EReference getUpdateTask_FindDOWith();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.UpdateTask#getUpdateDOWith <em>Update DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Update DO With</em>'.
     * @see sculptorguimetamodel.UpdateTask#getUpdateDOWith()
     * @see #getUpdateTask()
     * @generated
     */
	EReference getUpdateTask_UpdateDOWith();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.UpdateTask#getPopulateDOWith <em>Populate DO With</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Populate DO With</em>'.
     * @see sculptorguimetamodel.UpdateTask#getPopulateDOWith()
     * @see #getUpdateTask()
     * @generated
     */
    EReference getUpdateTask_PopulateDOWith();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.ViewTask <em>View Task</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Task</em>'.
     * @see sculptorguimetamodel.ViewTask
     * @generated
     */
	EClass getViewTask();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.ViewTask#getFindDOWith <em>Find DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Find DO With</em>'.
     * @see sculptorguimetamodel.ViewTask#getFindDOWith()
     * @see #getViewTask()
     * @generated
     */
	EReference getViewTask_FindDOWith();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.ListTask <em>List Task</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>List Task</em>'.
     * @see sculptorguimetamodel.ListTask
     * @generated
     */
	EClass getListTask();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.ListTask#getSearchDOWith <em>Search DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Search DO With</em>'.
     * @see sculptorguimetamodel.ListTask#getSearchDOWith()
     * @see #getListTask()
     * @generated
     */
	EReference getListTask_SearchDOWith();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.DeleteTask <em>Delete Task</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Delete Task</em>'.
     * @see sculptorguimetamodel.DeleteTask
     * @generated
     */
	EClass getDeleteTask();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.DeleteTask#getFindDOWith <em>Find DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Find DO With</em>'.
     * @see sculptorguimetamodel.DeleteTask#getFindDOWith()
     * @see #getDeleteTask()
     * @generated
     */
	EReference getDeleteTask_FindDOWith();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.DeleteTask#getDeleteDOWith <em>Delete DO With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Delete DO With</em>'.
     * @see sculptorguimetamodel.DeleteTask#getDeleteDOWith()
     * @see #getDeleteTask()
     * @generated
     */
	EReference getDeleteTask_DeleteDOWith();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.SubTaskTransition <em>Sub Task Transition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sub Task Transition</em>'.
     * @see sculptorguimetamodel.SubTaskTransition
     * @generated
     */
	EClass getSubTaskTransition();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.SubTaskTransition#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To</em>'.
     * @see sculptorguimetamodel.SubTaskTransition#getTo()
     * @see #getSubTaskTransition()
     * @generated
     */
	EReference getSubTaskTransition_To();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.SubTaskTransition#getForReference <em>For Reference</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>For Reference</em>'.
     * @see sculptorguimetamodel.SubTaskTransition#getForReference()
     * @see #getSubTaskTransition()
     * @generated
     */
	EReference getSubTaskTransition_ForReference();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.SubTaskTransition#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>From</em>'.
     * @see sculptorguimetamodel.SubTaskTransition#getFrom()
     * @see #getSubTaskTransition()
     * @generated
     */
	EReference getSubTaskTransition_From();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.ViewDataProperty <em>View Data Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Data Property</em>'.
     * @see sculptorguimetamodel.ViewDataProperty
     * @generated
     */
	EClass getViewDataProperty();

	/**
     * Returns the meta object for the container reference '{@link sculptorguimetamodel.ViewDataProperty#getUserTask <em>User Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>User Task</em>'.
     * @see sculptorguimetamodel.ViewDataProperty#getUserTask()
     * @see #getViewDataProperty()
     * @generated
     */
    EReference getViewDataProperty_UserTask();

    /**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.ViewDataProperty#getMessageKey <em>Message Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Message Key</em>'.
     * @see sculptorguimetamodel.ViewDataProperty#getMessageKey()
     * @see #getViewDataProperty()
     * @generated
     */
    EAttribute getViewDataProperty_MessageKey();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.TmpReferenceHolder <em>Tmp Reference Holder</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tmp Reference Holder</em>'.
     * @see sculptorguimetamodel.TmpReferenceHolder
     * @generated
     */
	EClass getTmpReferenceHolder();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.TmpReferenceHolder#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference</em>'.
     * @see sculptorguimetamodel.TmpReferenceHolder#getReference()
     * @see #getTmpReferenceHolder()
     * @generated
     */
	EReference getTmpReferenceHolder_Reference();

	/**
     * Returns the meta object for the containment reference list '{@link sculptorguimetamodel.TmpReferenceHolder#getSubTaskTransitionHolders <em>Sub Task Transition Holders</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Task Transition Holders</em>'.
     * @see sculptorguimetamodel.TmpReferenceHolder#getSubTaskTransitionHolders()
     * @see #getTmpReferenceHolder()
     * @generated
     */
	EReference getTmpReferenceHolder_SubTaskTransitionHolders();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder <em>Tmp Sub Task Transition Holder</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tmp Sub Task Transition Holder</em>'.
     * @see sculptorguimetamodel.TmpSubTaskTransitionHolder
     * @generated
     */
	EClass getTmpSubTaskTransitionHolder();

	/**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getToTaskType <em>To Task Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>To Task Type</em>'.
     * @see sculptorguimetamodel.TmpSubTaskTransitionHolder#getToTaskType()
     * @see #getTmpSubTaskTransitionHolder()
     * @generated
     */
	EAttribute getTmpSubTaskTransitionHolder_ToTaskType();

	/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To</em>'.
     * @see sculptorguimetamodel.TmpSubTaskTransitionHolder#getTo()
     * @see #getTmpSubTaskTransitionHolder()
     * @generated
     */
	EReference getTmpSubTaskTransitionHolder_To();

	/**
     * Returns the meta object for the container reference '{@link sculptorguimetamodel.TmpSubTaskTransitionHolder#getReferenceHoler <em>Reference Holer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Reference Holer</em>'.
     * @see sculptorguimetamodel.TmpSubTaskTransitionHolder#getReferenceHoler()
     * @see #getTmpSubTaskTransitionHolder()
     * @generated
     */
	EReference getTmpSubTaskTransitionHolder_ReferenceHoler();

	/**
     * Returns the meta object for class '{@link sculptorguimetamodel.ReferenceTarget <em>Reference Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference Target</em>'.
     * @see sculptorguimetamodel.ReferenceTarget
     * @generated
     */
    EClass getReferenceTarget();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.ReferenceTarget#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference</em>'.
     * @see sculptorguimetamodel.ReferenceTarget#getReference()
     * @see #getReferenceTarget()
     * @generated
     */
    EReference getReferenceTarget_Reference();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.ReferenceTarget#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see sculptorguimetamodel.ReferenceTarget#getTarget()
     * @see #getReferenceTarget()
     * @generated
     */
    EReference getReferenceTarget_Target();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.ReferenceViewProperty <em>Reference View Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference View Property</em>'.
     * @see sculptorguimetamodel.ReferenceViewProperty
     * @generated
     */
    EClass getReferenceViewProperty();

    /**
     * Returns the meta object for the reference list '{@link sculptorguimetamodel.ReferenceViewProperty#getRelatedTransitions <em>Related Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Related Transitions</em>'.
     * @see sculptorguimetamodel.ReferenceViewProperty#getRelatedTransitions()
     * @see #getReferenceViewProperty()
     * @generated
     */
    EReference getReferenceViewProperty_RelatedTransitions();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.ReferenceViewProperty#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference</em>'.
     * @see sculptorguimetamodel.ReferenceViewProperty#getReference()
     * @see #getReferenceViewProperty()
     * @generated
     */
    EReference getReferenceViewProperty_Reference();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.ReferenceViewProperty#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see sculptorguimetamodel.ReferenceViewProperty#getTarget()
     * @see #getReferenceViewProperty()
     * @generated
     */
    EReference getReferenceViewProperty_Target();

    /**
     * Returns the meta object for the attribute '{@link sculptorguimetamodel.ReferenceViewProperty#isBase <em>Base</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base</em>'.
     * @see sculptorguimetamodel.ReferenceViewProperty#isBase()
     * @see #getReferenceViewProperty()
     * @generated
     */
	EAttribute getReferenceViewProperty_Base();

				/**
     * Returns the meta object for the reference list '{@link sculptorguimetamodel.ReferenceViewProperty#getPreviewProperties <em>Preview Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Preview Properties</em>'.
     * @see sculptorguimetamodel.ReferenceViewProperty#getPreviewProperties()
     * @see #getReferenceViewProperty()
     * @generated
     */
    EReference getReferenceViewProperty_PreviewProperties();

                /**
     * Returns the meta object for class '{@link sculptorguimetamodel.AttributeViewProperty <em>Attribute View Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute View Property</em>'.
     * @see sculptorguimetamodel.AttributeViewProperty
     * @generated
     */
    EClass getAttributeViewProperty();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.AttributeViewProperty#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Attribute</em>'.
     * @see sculptorguimetamodel.AttributeViewProperty#getAttribute()
     * @see #getAttributeViewProperty()
     * @generated
     */
    EReference getAttributeViewProperty_Attribute();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.BasicTypeViewProperty <em>Basic Type View Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Basic Type View Property</em>'.
     * @see sculptorguimetamodel.BasicTypeViewProperty
     * @generated
     */
    EClass getBasicTypeViewProperty();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.BasicTypeViewProperty#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference</em>'.
     * @see sculptorguimetamodel.BasicTypeViewProperty#getReference()
     * @see #getBasicTypeViewProperty()
     * @generated
     */
    EReference getBasicTypeViewProperty_Reference();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.BasicTypeViewProperty#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Attribute</em>'.
     * @see sculptorguimetamodel.BasicTypeViewProperty#getAttribute()
     * @see #getBasicTypeViewProperty()
     * @generated
     */
    EReference getBasicTypeViewProperty_Attribute();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.EnumViewProperty <em>Enum View Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum View Property</em>'.
     * @see sculptorguimetamodel.EnumViewProperty
     * @generated
     */
    EClass getEnumViewProperty();

    /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.EnumViewProperty#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Reference</em>'.
     * @see sculptorguimetamodel.EnumViewProperty#getReference()
     * @see #getEnumViewProperty()
     * @generated
     */
    EReference getEnumViewProperty_Reference();

    /**
     * Returns the meta object for class '{@link sculptorguimetamodel.BasicTypeEnumViewProperty <em>Basic Type Enum View Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Basic Type Enum View Property</em>'.
     * @see sculptorguimetamodel.BasicTypeEnumViewProperty
     * @generated
     */
	EClass getBasicTypeEnumViewProperty();

				/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.BasicTypeEnumViewProperty#getBasicTypeReference <em>Basic Type Reference</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Basic Type Reference</em>'.
     * @see sculptorguimetamodel.BasicTypeEnumViewProperty#getBasicTypeReference()
     * @see #getBasicTypeEnumViewProperty()
     * @generated
     */
	EReference getBasicTypeEnumViewProperty_BasicTypeReference();

				/**
     * Returns the meta object for class '{@link sculptorguimetamodel.UserTaskGroup <em>User Task Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Task Group</em>'.
     * @see sculptorguimetamodel.UserTaskGroup
     * @generated
     */
	EClass getUserTaskGroup();

				/**
     * Returns the meta object for the reference list '{@link sculptorguimetamodel.UserTaskGroup#getUserTasks <em>User Tasks</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>User Tasks</em>'.
     * @see sculptorguimetamodel.UserTaskGroup#getUserTasks()
     * @see #getUserTaskGroup()
     * @generated
     */
	EReference getUserTaskGroup_UserTasks();

				/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.UserTaskGroup#getFor <em>For</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>For</em>'.
     * @see sculptorguimetamodel.UserTaskGroup#getFor()
     * @see #getUserTaskGroup()
     * @generated
     */
    EReference getUserTaskGroup_For();

                /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.UserTaskGroup#getModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Module</em>'.
     * @see sculptorguimetamodel.UserTaskGroup#getModule()
     * @see #getUserTaskGroup()
     * @generated
     */
    EReference getUserTaskGroup_Module();

                /**
     * Returns the meta object for class '{@link sculptorguimetamodel.DerivedReferenceViewProperty <em>Derived Reference View Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Derived Reference View Property</em>'.
     * @see sculptorguimetamodel.DerivedReferenceViewProperty
     * @generated
     */
	EClass getDerivedReferenceViewProperty();

				/**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.DerivedReferenceViewProperty#getDerivedFrom <em>Derived From</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Derived From</em>'.
     * @see sculptorguimetamodel.DerivedReferenceViewProperty#getDerivedFrom()
     * @see #getDerivedReferenceViewProperty()
     * @generated
     */
	EReference getDerivedReferenceViewProperty_DerivedFrom();

				/**
     * Returns the meta object for class '{@link sculptorguimetamodel.AddTask <em>Add Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Add Task</em>'.
     * @see sculptorguimetamodel.AddTask
     * @generated
     */
    EClass getAddTask();

                /**
     * Returns the meta object for the reference '{@link sculptorguimetamodel.AddTask#getFindDOWith <em>Find DO With</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Find DO With</em>'.
     * @see sculptorguimetamodel.AddTask#getFindDOWith()
     * @see #getAddTask()
     * @generated
     */
    EReference getAddTask_FindDOWith();

                /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	SculptorguimetamodelFactory getSculptorguimetamodelFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.GuiApplicationImpl <em>Gui Application</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.GuiApplicationImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getGuiApplication()
         * @generated
         */
		EClass GUI_APPLICATION = eINSTANCE.getGuiApplication();

		/**
         * The meta object literal for the '<em><b>Gui For Application</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GUI_APPLICATION__GUI_FOR_APPLICATION = eINSTANCE.getGuiApplication_GuiForApplication();

		/**
         * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GUI_APPLICATION__MODULES = eINSTANCE.getGuiApplication_Modules();

		/**
         * The meta object literal for the '<em><b>Base Package</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute GUI_APPLICATION__BASE_PACKAGE = eINSTANCE.getGuiApplication_BasePackage();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.GuiModuleImpl <em>Gui Module</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.GuiModuleImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getGuiModule()
         * @generated
         */
		EClass GUI_MODULE = eINSTANCE.getGuiModule();

		/**
         * The meta object literal for the '<em><b>User Tasks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GUI_MODULE__USER_TASKS = eINSTANCE.getGuiModule_UserTasks();

		/**
         * The meta object literal for the '<em><b>Base Package</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute GUI_MODULE__BASE_PACKAGE = eINSTANCE.getGuiModule_BasePackage();

		/**
         * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GUI_MODULE__APPLICATION = eINSTANCE.getGuiModule_Application();

		/**
         * The meta object literal for the '<em><b>For</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GUI_MODULE__FOR = eINSTANCE.getGuiModule_For();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.UserTaskImpl <em>User Task</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.UserTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getUserTask()
         * @generated
         */
		EClass USER_TASK = eINSTANCE.getUserTask();

		/**
         * The meta object literal for the '<em><b>Sub Task Transitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference USER_TASK__SUB_TASK_TRANSITIONS = eINSTANCE.getUserTask_SubTaskTransitions();

		/**
         * The meta object literal for the '<em><b>For</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference USER_TASK__FOR = eINSTANCE.getUserTask_For();

		/**
         * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute USER_TASK__ABSTRACT = eINSTANCE.getUserTask_Abstract();

		/**
         * The meta object literal for the '<em><b>Module</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference USER_TASK__MODULE = eINSTANCE.getUserTask_Module();

		/**
         * The meta object literal for the '<em><b>Task Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute USER_TASK__TASK_TYPE = eINSTANCE.getUserTask_TaskType();

		/**
         * The meta object literal for the '<em><b>View Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_TASK__VIEW_PROPERTIES = eINSTANCE.getUserTask_ViewProperties();

        /**
         * The meta object literal for the '<em><b>Conversation Root</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_TASK__CONVERSATION_ROOT = eINSTANCE.getUserTask_ConversationRoot();

        /**
         * The meta object literal for the '<em><b>Gap Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_TASK__GAP_CLASS = eINSTANCE.getUserTask_GapClass();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.CreateTaskImpl <em>Create Task</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.CreateTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getCreateTask()
         * @generated
         */
		EClass CREATE_TASK = eINSTANCE.getCreateTask();

		/**
         * The meta object literal for the '<em><b>Create DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CREATE_TASK__CREATE_DO_WITH = eINSTANCE.getCreateTask_CreateDOWith();

		/**
         * The meta object literal for the '<em><b>Populate DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CREATE_TASK__POPULATE_DO_WITH = eINSTANCE.getCreateTask_PopulateDOWith();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.UpdateTaskImpl <em>Update Task</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.UpdateTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getUpdateTask()
         * @generated
         */
		EClass UPDATE_TASK = eINSTANCE.getUpdateTask();

		/**
         * The meta object literal for the '<em><b>Find DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference UPDATE_TASK__FIND_DO_WITH = eINSTANCE.getUpdateTask_FindDOWith();

		/**
         * The meta object literal for the '<em><b>Update DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference UPDATE_TASK__UPDATE_DO_WITH = eINSTANCE.getUpdateTask_UpdateDOWith();

		/**
         * The meta object literal for the '<em><b>Populate DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UPDATE_TASK__POPULATE_DO_WITH = eINSTANCE.getUpdateTask_PopulateDOWith();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.ViewTaskImpl <em>View Task</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.ViewTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getViewTask()
         * @generated
         */
		EClass VIEW_TASK = eINSTANCE.getViewTask();

		/**
         * The meta object literal for the '<em><b>Find DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VIEW_TASK__FIND_DO_WITH = eINSTANCE.getViewTask_FindDOWith();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.ListTaskImpl <em>List Task</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.ListTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getListTask()
         * @generated
         */
		EClass LIST_TASK = eINSTANCE.getListTask();

		/**
         * The meta object literal for the '<em><b>Search DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LIST_TASK__SEARCH_DO_WITH = eINSTANCE.getListTask_SearchDOWith();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.DeleteTaskImpl <em>Delete Task</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.DeleteTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getDeleteTask()
         * @generated
         */
		EClass DELETE_TASK = eINSTANCE.getDeleteTask();

		/**
         * The meta object literal for the '<em><b>Find DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DELETE_TASK__FIND_DO_WITH = eINSTANCE.getDeleteTask_FindDOWith();

		/**
         * The meta object literal for the '<em><b>Delete DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DELETE_TASK__DELETE_DO_WITH = eINSTANCE.getDeleteTask_DeleteDOWith();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.SubTaskTransitionImpl <em>Sub Task Transition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.SubTaskTransitionImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getSubTaskTransition()
         * @generated
         */
		EClass SUB_TASK_TRANSITION = eINSTANCE.getSubTaskTransition();

		/**
         * The meta object literal for the '<em><b>To</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SUB_TASK_TRANSITION__TO = eINSTANCE.getSubTaskTransition_To();

		/**
         * The meta object literal for the '<em><b>For Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SUB_TASK_TRANSITION__FOR_REFERENCE = eINSTANCE.getSubTaskTransition_ForReference();

		/**
         * The meta object literal for the '<em><b>From</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SUB_TASK_TRANSITION__FROM = eINSTANCE.getSubTaskTransition_From();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.ViewDataPropertyImpl <em>View Data Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.ViewDataPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getViewDataProperty()
         * @generated
         */
		EClass VIEW_DATA_PROPERTY = eINSTANCE.getViewDataProperty();

		/**
         * The meta object literal for the '<em><b>User Task</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIEW_DATA_PROPERTY__USER_TASK = eINSTANCE.getViewDataProperty_UserTask();

        /**
         * The meta object literal for the '<em><b>Message Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIEW_DATA_PROPERTY__MESSAGE_KEY = eINSTANCE.getViewDataProperty_MessageKey();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.TmpReferenceHolderImpl <em>Tmp Reference Holder</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.TmpReferenceHolderImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getTmpReferenceHolder()
         * @generated
         */
		EClass TMP_REFERENCE_HOLDER = eINSTANCE.getTmpReferenceHolder();

		/**
         * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TMP_REFERENCE_HOLDER__REFERENCE = eINSTANCE.getTmpReferenceHolder_Reference();

		/**
         * The meta object literal for the '<em><b>Sub Task Transition Holders</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS = eINSTANCE.getTmpReferenceHolder_SubTaskTransitionHolders();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl <em>Tmp Sub Task Transition Holder</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getTmpSubTaskTransitionHolder()
         * @generated
         */
		EClass TMP_SUB_TASK_TRANSITION_HOLDER = eINSTANCE.getTmpSubTaskTransitionHolder();

		/**
         * The meta object literal for the '<em><b>To Task Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE = eINSTANCE.getTmpSubTaskTransitionHolder_ToTaskType();

		/**
         * The meta object literal for the '<em><b>To</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TMP_SUB_TASK_TRANSITION_HOLDER__TO = eINSTANCE.getTmpSubTaskTransitionHolder_To();

		/**
         * The meta object literal for the '<em><b>Reference Holer</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER = eINSTANCE.getTmpSubTaskTransitionHolder_ReferenceHoler();

		/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.ReferenceTargetImpl <em>Reference Target</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.ReferenceTargetImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getReferenceTarget()
         * @generated
         */
        EClass REFERENCE_TARGET = eINSTANCE.getReferenceTarget();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_TARGET__REFERENCE = eINSTANCE.getReferenceTarget_Reference();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_TARGET__TARGET = eINSTANCE.getReferenceTarget_Target();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl <em>Reference View Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.ReferenceViewPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getReferenceViewProperty()
         * @generated
         */
        EClass REFERENCE_VIEW_PROPERTY = eINSTANCE.getReferenceViewProperty();

        /**
         * The meta object literal for the '<em><b>Related Transitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS = eINSTANCE.getReferenceViewProperty_RelatedTransitions();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_VIEW_PROPERTY__REFERENCE = eINSTANCE.getReferenceViewProperty_Reference();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_VIEW_PROPERTY__TARGET = eINSTANCE.getReferenceViewProperty_Target();

        /**
         * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute REFERENCE_VIEW_PROPERTY__BASE = eINSTANCE.getReferenceViewProperty_Base();

								/**
         * The meta object literal for the '<em><b>Preview Properties</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES = eINSTANCE.getReferenceViewProperty_PreviewProperties();

                                /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.AttributeViewPropertyImpl <em>Attribute View Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.AttributeViewPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getAttributeViewProperty()
         * @generated
         */
        EClass ATTRIBUTE_VIEW_PROPERTY = eINSTANCE.getAttributeViewProperty();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_VIEW_PROPERTY__ATTRIBUTE = eINSTANCE.getAttributeViewProperty_Attribute();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.BasicTypeViewPropertyImpl <em>Basic Type View Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.BasicTypeViewPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getBasicTypeViewProperty()
         * @generated
         */
        EClass BASIC_TYPE_VIEW_PROPERTY = eINSTANCE.getBasicTypeViewProperty();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BASIC_TYPE_VIEW_PROPERTY__REFERENCE = eINSTANCE.getBasicTypeViewProperty_Reference();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE = eINSTANCE.getBasicTypeViewProperty_Attribute();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.EnumViewPropertyImpl <em>Enum View Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.EnumViewPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getEnumViewProperty()
         * @generated
         */
        EClass ENUM_VIEW_PROPERTY = eINSTANCE.getEnumViewProperty();

        /**
         * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENUM_VIEW_PROPERTY__REFERENCE = eINSTANCE.getEnumViewProperty_Reference();

        /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.BasicTypeEnumViewPropertyImpl <em>Basic Type Enum View Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.BasicTypeEnumViewPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getBasicTypeEnumViewProperty()
         * @generated
         */
		EClass BASIC_TYPE_ENUM_VIEW_PROPERTY = eINSTANCE.getBasicTypeEnumViewProperty();

								/**
         * The meta object literal for the '<em><b>Basic Type Reference</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE = eINSTANCE.getBasicTypeEnumViewProperty_BasicTypeReference();

								/**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.UserTaskGroupImpl <em>User Task Group</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.UserTaskGroupImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getUserTaskGroup()
         * @generated
         */
		EClass USER_TASK_GROUP = eINSTANCE.getUserTaskGroup();

								/**
         * The meta object literal for the '<em><b>User Tasks</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference USER_TASK_GROUP__USER_TASKS = eINSTANCE.getUserTaskGroup_UserTasks();

								/**
         * The meta object literal for the '<em><b>For</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_TASK_GROUP__FOR = eINSTANCE.getUserTaskGroup_For();

                                /**
         * The meta object literal for the '<em><b>Module</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference USER_TASK_GROUP__MODULE = eINSTANCE.getUserTaskGroup_Module();

                                /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.DerivedReferenceViewPropertyImpl <em>Derived Reference View Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.DerivedReferenceViewPropertyImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getDerivedReferenceViewProperty()
         * @generated
         */
		EClass DERIVED_REFERENCE_VIEW_PROPERTY = eINSTANCE.getDerivedReferenceViewProperty();

								/**
         * The meta object literal for the '<em><b>Derived From</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM = eINSTANCE.getDerivedReferenceViewProperty_DerivedFrom();

                                /**
         * The meta object literal for the '{@link sculptorguimetamodel.impl.AddTaskImpl <em>Add Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see sculptorguimetamodel.impl.AddTaskImpl
         * @see sculptorguimetamodel.impl.SculptorguimetamodelPackageImpl#getAddTask()
         * @generated
         */
        EClass ADD_TASK = eINSTANCE.getAddTask();

                                /**
         * The meta object literal for the '<em><b>Find DO With</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ADD_TASK__FIND_DO_WITH = eINSTANCE.getAddTask_FindDOWith();

	}

} //SculptorguimetamodelPackage
