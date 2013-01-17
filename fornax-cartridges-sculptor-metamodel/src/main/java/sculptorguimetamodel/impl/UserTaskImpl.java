/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.ViewDataProperty;

import sculptormetamodel.DomainObject;
import sculptormetamodel.Service;

import sculptormetamodel.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#getSubTaskTransitions <em>Sub Task Transitions</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#getFor <em>For</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#getModule <em>Module</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#getTaskType <em>Task Type</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#getViewProperties <em>View Properties</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#isConversationRoot <em>Conversation Root</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskImpl#isGapClass <em>Gap Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserTaskImpl extends NamedElementImpl implements UserTask {
	/**
     * The cached value of the '{@link #getSubTaskTransitions() <em>Sub Task Transitions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSubTaskTransitions()
     * @generated
     * @ordered
     */
	protected EList subTaskTransitions;

	/**
     * The cached value of the '{@link #getFor() <em>For</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFor()
     * @generated
     * @ordered
     */
	protected DomainObject for_;

	/**
     * The default value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbstract()
     * @generated
     * @ordered
     */
	protected static final Boolean ABSTRACT_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbstract()
     * @generated
     * @ordered
     */
	protected Boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
     * The default value of the '{@link #getTaskType() <em>Task Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTaskType()
     * @generated
     * @ordered
     */
	protected static final String TASK_TYPE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTaskType() <em>Task Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTaskType()
     * @generated
     * @ordered
     */
	protected String taskType = TASK_TYPE_EDEFAULT;

	/**
     * The cached value of the '{@link #getViewProperties() <em>View Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getViewProperties()
     * @generated
     * @ordered
     */
    protected EList viewProperties;

    /**
     * The default value of the '{@link #isConversationRoot() <em>Conversation Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isConversationRoot()
     * @generated
     * @ordered
     */
    protected static final boolean CONVERSATION_ROOT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isConversationRoot() <em>Conversation Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isConversationRoot()
     * @generated
     * @ordered
     */
    protected boolean conversationRoot = CONVERSATION_ROOT_EDEFAULT;

    /**
     * The default value of the '{@link #isGapClass() <em>Gap Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGapClass()
     * @generated
     * @ordered
     */
    protected static final boolean GAP_CLASS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGapClass() <em>Gap Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGapClass()
     * @generated
     * @ordered
     */
    protected boolean gapClass = GAP_CLASS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected UserTaskImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.USER_TASK;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getSubTaskTransitions() {
        if (subTaskTransitions == null) {
            subTaskTransitions = new EObjectContainmentEList(SubTaskTransition.class, this, SculptorguimetamodelPackage.USER_TASK__SUB_TASK_TRANSITIONS);
        }
        return subTaskTransitions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject getFor() {
        if (for_ != null && for_.eIsProxy()) {
            InternalEObject oldFor = (InternalEObject)for_;
            for_ = (DomainObject)eResolveProxy(oldFor);
            if (for_ != oldFor) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.USER_TASK__FOR, oldFor, for_));
            }
        }
        return for_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject basicGetFor() {
        return for_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFor(DomainObject newFor) {
        DomainObject oldFor = for_;
        for_ = newFor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK__FOR, oldFor, for_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Boolean getAbstract() {
        return abstract_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbstract(Boolean newAbstract) {
        Boolean oldAbstract = abstract_;
        abstract_ = newAbstract;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK__ABSTRACT, oldAbstract, abstract_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GuiModule getModule() {
        if (eContainerFeatureID() != SculptorguimetamodelPackage.USER_TASK__MODULE) return null;
        return (GuiModule)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetModule(GuiModule newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newModule, SculptorguimetamodelPackage.USER_TASK__MODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModule(GuiModule newModule) {
        if (newModule != eInternalContainer() || (eContainerFeatureID() != SculptorguimetamodelPackage.USER_TASK__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newModule != null)
                msgs = ((InternalEObject)newModule).eInverseAdd(this, SculptorguimetamodelPackage.GUI_MODULE__USER_TASKS, GuiModule.class, msgs);
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK__MODULE, newModule, newModule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTaskType() {
        return taskType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTaskType(String newTaskType) {
        String oldTaskType = taskType;
        taskType = newTaskType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK__TASK_TYPE, oldTaskType, taskType));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getViewProperties() {
        if (viewProperties == null) {
            viewProperties = new EObjectContainmentWithInverseEList(ViewDataProperty.class, this, SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES, SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK);
        }
        return viewProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isConversationRoot() {
        return conversationRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConversationRoot(boolean newConversationRoot) {
        boolean oldConversationRoot = conversationRoot;
        conversationRoot = newConversationRoot;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK__CONVERSATION_ROOT, oldConversationRoot, conversationRoot));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isGapClass() {
        return gapClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGapClass(boolean newGapClass) {
        boolean oldGapClass = gapClass;
        gapClass = newGapClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK__GAP_CLASS, oldGapClass, gapClass));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetModule((GuiModule)otherEnd, msgs);
            case SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES:
                return ((InternalEList)getViewProperties()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK__SUB_TASK_TRANSITIONS:
                return ((InternalEList)getSubTaskTransitions()).basicRemove(otherEnd, msgs);
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                return basicSetModule(null, msgs);
            case SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES:
                return ((InternalEList)getViewProperties()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                return eInternalContainer().eInverseRemove(this, SculptorguimetamodelPackage.GUI_MODULE__USER_TASKS, GuiModule.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK__SUB_TASK_TRANSITIONS:
                return getSubTaskTransitions();
            case SculptorguimetamodelPackage.USER_TASK__FOR:
                if (resolve) return getFor();
                return basicGetFor();
            case SculptorguimetamodelPackage.USER_TASK__ABSTRACT:
                return getAbstract();
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                return getModule();
            case SculptorguimetamodelPackage.USER_TASK__TASK_TYPE:
                return getTaskType();
            case SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES:
                return getViewProperties();
            case SculptorguimetamodelPackage.USER_TASK__CONVERSATION_ROOT:
                return isConversationRoot() ? Boolean.TRUE : Boolean.FALSE;
            case SculptorguimetamodelPackage.USER_TASK__GAP_CLASS:
                return isGapClass() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK__SUB_TASK_TRANSITIONS:
                getSubTaskTransitions().clear();
                getSubTaskTransitions().addAll((Collection)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK__FOR:
                setFor((DomainObject)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK__ABSTRACT:
                setAbstract((Boolean)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                setModule((GuiModule)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK__TASK_TYPE:
                setTaskType((String)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES:
                getViewProperties().clear();
                getViewProperties().addAll((Collection)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK__CONVERSATION_ROOT:
                setConversationRoot(((Boolean)newValue).booleanValue());
                return;
            case SculptorguimetamodelPackage.USER_TASK__GAP_CLASS:
                setGapClass(((Boolean)newValue).booleanValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK__SUB_TASK_TRANSITIONS:
                getSubTaskTransitions().clear();
                return;
            case SculptorguimetamodelPackage.USER_TASK__FOR:
                setFor((DomainObject)null);
                return;
            case SculptorguimetamodelPackage.USER_TASK__ABSTRACT:
                setAbstract(ABSTRACT_EDEFAULT);
                return;
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                setModule((GuiModule)null);
                return;
            case SculptorguimetamodelPackage.USER_TASK__TASK_TYPE:
                setTaskType(TASK_TYPE_EDEFAULT);
                return;
            case SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES:
                getViewProperties().clear();
                return;
            case SculptorguimetamodelPackage.USER_TASK__CONVERSATION_ROOT:
                setConversationRoot(CONVERSATION_ROOT_EDEFAULT);
                return;
            case SculptorguimetamodelPackage.USER_TASK__GAP_CLASS:
                setGapClass(GAP_CLASS_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK__SUB_TASK_TRANSITIONS:
                return subTaskTransitions != null && !subTaskTransitions.isEmpty();
            case SculptorguimetamodelPackage.USER_TASK__FOR:
                return for_ != null;
            case SculptorguimetamodelPackage.USER_TASK__ABSTRACT:
                return ABSTRACT_EDEFAULT == null ? abstract_ != null : !ABSTRACT_EDEFAULT.equals(abstract_);
            case SculptorguimetamodelPackage.USER_TASK__MODULE:
                return getModule() != null;
            case SculptorguimetamodelPackage.USER_TASK__TASK_TYPE:
                return TASK_TYPE_EDEFAULT == null ? taskType != null : !TASK_TYPE_EDEFAULT.equals(taskType);
            case SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES:
                return viewProperties != null && !viewProperties.isEmpty();
            case SculptorguimetamodelPackage.USER_TASK__CONVERSATION_ROOT:
                return conversationRoot != CONVERSATION_ROOT_EDEFAULT;
            case SculptorguimetamodelPackage.USER_TASK__GAP_CLASS:
                return gapClass != GAP_CLASS_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (abstract: ");
        result.append(abstract_);
        result.append(", taskType: ");
        result.append(taskType);
        result.append(", conversationRoot: ");
        result.append(conversationRoot);
        result.append(", gapClass: ");
        result.append(gapClass);
        result.append(')');
        return result.toString();
    }

} //UserTaskImpl
