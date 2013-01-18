/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import sculptormetamodel.Consumer;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Module;
import sculptormetamodel.Repository;
import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Service;
import sculptormetamodel.Subscribe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consumer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getModule <em>Module</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getRepositoryDependencies <em>Repository Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getServiceDependencies <em>Service Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getMessageRoot <em>Message Root</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getOtherDependencies <em>Other Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ConsumerImpl#getSubscribe <em>Subscribe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConsumerImpl extends NamedElementImpl implements Consumer {
    /**
     * The cached value of the '{@link #getRepositoryDependencies() <em>Repository Dependencies</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRepositoryDependencies()
     * @generated
     * @ordered
     */
    protected EList repositoryDependencies;

    /**
     * The cached value of the '{@link #getServiceDependencies() <em>Service Dependencies</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceDependencies()
     * @generated
     * @ordered
     */
    protected EList serviceDependencies;

    /**
     * The default value of the '{@link #getChannel() <em>Channel</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChannel()
     * @generated
     * @ordered
     */
    protected static final String CHANNEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getChannel() <em>Channel</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChannel()
     * @generated
     * @ordered
     */
    protected String channel = CHANNEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getMessageRoot() <em>Message Root</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageRoot()
     * @generated
     * @ordered
     */
    protected DomainObject messageRoot;

    /**
     * The cached value of the '{@link #getOtherDependencies() <em>Other Dependencies</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtherDependencies()
     * @generated
     * @ordered
     */
    protected EList otherDependencies;

    /**
     * The cached value of the '{@link #getSubscribe() <em>Subscribe</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubscribe()
     * @generated
     * @ordered
     */
    protected Subscribe subscribe;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConsumerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.CONSUMER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Module getModule() {
        if (eContainerFeatureID() != SculptormetamodelPackage.CONSUMER__MODULE) return null;
        return (Module)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newModule, SculptormetamodelPackage.CONSUMER__MODULE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModule(Module newModule) {
        if (newModule != eInternalContainer() || (eContainerFeatureID() != SculptormetamodelPackage.CONSUMER__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newModule != null)
                msgs = ((InternalEObject)newModule).eInverseAdd(this, SculptormetamodelPackage.MODULE__CONSUMERS, Module.class, msgs);
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.CONSUMER__MODULE, newModule, newModule));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getRepositoryDependencies() {
        if (repositoryDependencies == null) {
            repositoryDependencies = new EObjectResolvingEList(Repository.class, this, SculptormetamodelPackage.CONSUMER__REPOSITORY_DEPENDENCIES);
        }
        return repositoryDependencies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getServiceDependencies() {
        if (serviceDependencies == null) {
            serviceDependencies = new EObjectResolvingEList(Service.class, this, SculptormetamodelPackage.CONSUMER__SERVICE_DEPENDENCIES);
        }
        return serviceDependencies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getChannel() {
        return channel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setChannel(String newChannel) {
        String oldChannel = channel;
        channel = newChannel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.CONSUMER__CHANNEL, oldChannel, channel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject getMessageRoot() {
        if (messageRoot != null && messageRoot.eIsProxy()) {
            InternalEObject oldMessageRoot = (InternalEObject)messageRoot;
            messageRoot = (DomainObject)eResolveProxy(oldMessageRoot);
            if (messageRoot != oldMessageRoot) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.CONSUMER__MESSAGE_ROOT, oldMessageRoot, messageRoot));
            }
        }
        return messageRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject basicGetMessageRoot() {
        return messageRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMessageRoot(DomainObject newMessageRoot) {
        DomainObject oldMessageRoot = messageRoot;
        messageRoot = newMessageRoot;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.CONSUMER__MESSAGE_ROOT, oldMessageRoot, messageRoot));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getOtherDependencies() {
        if (otherDependencies == null) {
            otherDependencies = new EDataTypeUniqueEList(String.class, this, SculptormetamodelPackage.CONSUMER__OTHER_DEPENDENCIES);
        }
        return otherDependencies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Subscribe getSubscribe() {
        if (subscribe != null && subscribe.eIsProxy()) {
            InternalEObject oldSubscribe = (InternalEObject)subscribe;
            subscribe = (Subscribe)eResolveProxy(oldSubscribe);
            if (subscribe != oldSubscribe) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.CONSUMER__SUBSCRIBE, oldSubscribe, subscribe));
            }
        }
        return subscribe;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Subscribe basicGetSubscribe() {
        return subscribe;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubscribe(Subscribe newSubscribe) {
        Subscribe oldSubscribe = subscribe;
        subscribe = newSubscribe;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.CONSUMER__SUBSCRIBE, oldSubscribe, subscribe));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.CONSUMER__MODULE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetModule((Module)otherEnd, msgs);
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
            case SculptormetamodelPackage.CONSUMER__MODULE:
                return basicSetModule(null, msgs);
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
            case SculptormetamodelPackage.CONSUMER__MODULE:
                return eInternalContainer().eInverseRemove(this, SculptormetamodelPackage.MODULE__CONSUMERS, Module.class, msgs);
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
            case SculptormetamodelPackage.CONSUMER__MODULE:
                return getModule();
            case SculptormetamodelPackage.CONSUMER__REPOSITORY_DEPENDENCIES:
                return getRepositoryDependencies();
            case SculptormetamodelPackage.CONSUMER__SERVICE_DEPENDENCIES:
                return getServiceDependencies();
            case SculptormetamodelPackage.CONSUMER__CHANNEL:
                return getChannel();
            case SculptormetamodelPackage.CONSUMER__MESSAGE_ROOT:
                if (resolve) return getMessageRoot();
                return basicGetMessageRoot();
            case SculptormetamodelPackage.CONSUMER__OTHER_DEPENDENCIES:
                return getOtherDependencies();
            case SculptormetamodelPackage.CONSUMER__SUBSCRIBE:
                if (resolve) return getSubscribe();
                return basicGetSubscribe();
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
            case SculptormetamodelPackage.CONSUMER__MODULE:
                setModule((Module)newValue);
                return;
            case SculptormetamodelPackage.CONSUMER__REPOSITORY_DEPENDENCIES:
                getRepositoryDependencies().clear();
                getRepositoryDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.CONSUMER__SERVICE_DEPENDENCIES:
                getServiceDependencies().clear();
                getServiceDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.CONSUMER__CHANNEL:
                setChannel((String)newValue);
                return;
            case SculptormetamodelPackage.CONSUMER__MESSAGE_ROOT:
                setMessageRoot((DomainObject)newValue);
                return;
            case SculptormetamodelPackage.CONSUMER__OTHER_DEPENDENCIES:
                getOtherDependencies().clear();
                getOtherDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.CONSUMER__SUBSCRIBE:
                setSubscribe((Subscribe)newValue);
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
            case SculptormetamodelPackage.CONSUMER__MODULE:
                setModule((Module)null);
                return;
            case SculptormetamodelPackage.CONSUMER__REPOSITORY_DEPENDENCIES:
                getRepositoryDependencies().clear();
                return;
            case SculptormetamodelPackage.CONSUMER__SERVICE_DEPENDENCIES:
                getServiceDependencies().clear();
                return;
            case SculptormetamodelPackage.CONSUMER__CHANNEL:
                setChannel(CHANNEL_EDEFAULT);
                return;
            case SculptormetamodelPackage.CONSUMER__MESSAGE_ROOT:
                setMessageRoot((DomainObject)null);
                return;
            case SculptormetamodelPackage.CONSUMER__OTHER_DEPENDENCIES:
                getOtherDependencies().clear();
                return;
            case SculptormetamodelPackage.CONSUMER__SUBSCRIBE:
                setSubscribe((Subscribe)null);
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
            case SculptormetamodelPackage.CONSUMER__MODULE:
                return getModule() != null;
            case SculptormetamodelPackage.CONSUMER__REPOSITORY_DEPENDENCIES:
                return repositoryDependencies != null && !repositoryDependencies.isEmpty();
            case SculptormetamodelPackage.CONSUMER__SERVICE_DEPENDENCIES:
                return serviceDependencies != null && !serviceDependencies.isEmpty();
            case SculptormetamodelPackage.CONSUMER__CHANNEL:
                return CHANNEL_EDEFAULT == null ? channel != null : !CHANNEL_EDEFAULT.equals(channel);
            case SculptormetamodelPackage.CONSUMER__MESSAGE_ROOT:
                return messageRoot != null;
            case SculptormetamodelPackage.CONSUMER__OTHER_DEPENDENCIES:
                return otherDependencies != null && !otherDependencies.isEmpty();
            case SculptormetamodelPackage.CONSUMER__SUBSCRIBE:
                return subscribe != null;
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
        result.append(" (channel: ");
        result.append(channel);
        result.append(", otherDependencies: ");
        result.append(otherDependencies);
        result.append(')');
        return result.toString();
    }

} //ConsumerImpl