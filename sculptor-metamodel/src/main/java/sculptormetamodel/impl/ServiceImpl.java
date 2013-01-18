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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptormetamodel.Module;
import sculptormetamodel.Repository;
import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;
import sculptormetamodel.Subscribe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#getRepositoryDependencies <em>Repository Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#getModule <em>Module</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#getOtherDependencies <em>Other Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#getServiceDependencies <em>Service Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#isGapClass <em>Gap Class</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#isWebService <em>Web Service</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#isRemoteInterface <em>Remote Interface</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#isLocalInterface <em>Local Interface</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ServiceImpl#getSubscribe <em>Subscribe</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends NamedElementImpl implements Service {
    /**
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
	protected EList operations;

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
     * The cached value of the '{@link #getOtherDependencies() <em>Other Dependencies</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtherDependencies()
     * @generated
     * @ordered
     */
    protected EList otherDependencies;

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
     * The default value of the '{@link #isWebService() <em>Web Service</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isWebService()
     * @generated
     * @ordered
     */
    protected static final boolean WEB_SERVICE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isWebService() <em>Web Service</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isWebService()
     * @generated
     * @ordered
     */
    protected boolean webService = WEB_SERVICE_EDEFAULT;

    /**
     * The default value of the '{@link #isRemoteInterface() <em>Remote Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRemoteInterface()
     * @generated
     * @ordered
     */
    protected static final boolean REMOTE_INTERFACE_EDEFAULT = true;

                /**
     * The cached value of the '{@link #isRemoteInterface() <em>Remote Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRemoteInterface()
     * @generated
     * @ordered
     */
    protected boolean remoteInterface = REMOTE_INTERFACE_EDEFAULT;

                /**
     * The default value of the '{@link #isLocalInterface() <em>Local Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLocalInterface()
     * @generated
     * @ordered
     */
    protected static final boolean LOCAL_INTERFACE_EDEFAULT = true;

                /**
     * The cached value of the '{@link #isLocalInterface() <em>Local Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLocalInterface()
     * @generated
     * @ordered
     */
    protected boolean localInterface = LOCAL_INTERFACE_EDEFAULT;

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
	protected ServiceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.SERVICE;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentWithInverseEList(ServiceOperation.class, this, SculptormetamodelPackage.SERVICE__OPERATIONS, SculptormetamodelPackage.SERVICE_OPERATION__SERVICE);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Module getModule() {
        if (eContainerFeatureID() != SculptormetamodelPackage.SERVICE__MODULE) return null;
        return (Module)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newModule, SculptormetamodelPackage.SERVICE__MODULE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModule(Module newModule) {
        if (newModule != eInternalContainer() || (eContainerFeatureID() != SculptormetamodelPackage.SERVICE__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newModule != null)
                msgs = ((InternalEObject)newModule).eInverseAdd(this, SculptormetamodelPackage.MODULE__SERVICES, Module.class, msgs);
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SERVICE__MODULE, newModule, newModule));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getOtherDependencies() {
        if (otherDependencies == null) {
            otherDependencies = new EDataTypeUniqueEList(String.class, this, SculptormetamodelPackage.SERVICE__OTHER_DEPENDENCIES);
        }
        return otherDependencies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getServiceDependencies() {
        if (serviceDependencies == null) {
            serviceDependencies = new EObjectResolvingEList(Service.class, this, SculptormetamodelPackage.SERVICE__SERVICE_DEPENDENCIES);
        }
        return serviceDependencies;
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SERVICE__GAP_CLASS, oldGapClass, gapClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isWebService() {
        return webService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWebService(boolean newWebService) {
        boolean oldWebService = webService;
        webService = newWebService;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SERVICE__WEB_SERVICE, oldWebService, webService));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRemoteInterface() {
        return remoteInterface;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRemoteInterface(boolean newRemoteInterface) {
        boolean oldRemoteInterface = remoteInterface;
        remoteInterface = newRemoteInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SERVICE__REMOTE_INTERFACE, oldRemoteInterface, remoteInterface));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLocalInterface() {
        return localInterface;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalInterface(boolean newLocalInterface) {
        boolean oldLocalInterface = localInterface;
        localInterface = newLocalInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SERVICE__LOCAL_INTERFACE, oldLocalInterface, localInterface));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.SERVICE__SUBSCRIBE, oldSubscribe, subscribe));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SERVICE__SUBSCRIBE, oldSubscribe, subscribe));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getRepositoryDependencies() {
        if (repositoryDependencies == null) {
            repositoryDependencies = new EObjectResolvingEList(Repository.class, this, SculptormetamodelPackage.SERVICE__REPOSITORY_DEPENDENCIES);
        }
        return repositoryDependencies;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.SERVICE__OPERATIONS:
                return ((InternalEList)getOperations()).basicAdd(otherEnd, msgs);
            case SculptormetamodelPackage.SERVICE__MODULE:
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
            case SculptormetamodelPackage.SERVICE__OPERATIONS:
                return ((InternalEList)getOperations()).basicRemove(otherEnd, msgs);
            case SculptormetamodelPackage.SERVICE__MODULE:
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
            case SculptormetamodelPackage.SERVICE__MODULE:
                return eInternalContainer().eInverseRemove(this, SculptormetamodelPackage.MODULE__SERVICES, Module.class, msgs);
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
            case SculptormetamodelPackage.SERVICE__OPERATIONS:
                return getOperations();
            case SculptormetamodelPackage.SERVICE__REPOSITORY_DEPENDENCIES:
                return getRepositoryDependencies();
            case SculptormetamodelPackage.SERVICE__MODULE:
                return getModule();
            case SculptormetamodelPackage.SERVICE__OTHER_DEPENDENCIES:
                return getOtherDependencies();
            case SculptormetamodelPackage.SERVICE__SERVICE_DEPENDENCIES:
                return getServiceDependencies();
            case SculptormetamodelPackage.SERVICE__GAP_CLASS:
                return isGapClass() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.SERVICE__WEB_SERVICE:
                return isWebService() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.SERVICE__REMOTE_INTERFACE:
                return isRemoteInterface() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.SERVICE__LOCAL_INTERFACE:
                return isLocalInterface() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.SERVICE__SUBSCRIBE:
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
            case SculptormetamodelPackage.SERVICE__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.SERVICE__REPOSITORY_DEPENDENCIES:
                getRepositoryDependencies().clear();
                getRepositoryDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.SERVICE__MODULE:
                setModule((Module)newValue);
                return;
            case SculptormetamodelPackage.SERVICE__OTHER_DEPENDENCIES:
                getOtherDependencies().clear();
                getOtherDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.SERVICE__SERVICE_DEPENDENCIES:
                getServiceDependencies().clear();
                getServiceDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.SERVICE__GAP_CLASS:
                setGapClass(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.SERVICE__WEB_SERVICE:
                setWebService(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.SERVICE__REMOTE_INTERFACE:
                setRemoteInterface(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.SERVICE__LOCAL_INTERFACE:
                setLocalInterface(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.SERVICE__SUBSCRIBE:
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
            case SculptormetamodelPackage.SERVICE__OPERATIONS:
                getOperations().clear();
                return;
            case SculptormetamodelPackage.SERVICE__REPOSITORY_DEPENDENCIES:
                getRepositoryDependencies().clear();
                return;
            case SculptormetamodelPackage.SERVICE__MODULE:
                setModule((Module)null);
                return;
            case SculptormetamodelPackage.SERVICE__OTHER_DEPENDENCIES:
                getOtherDependencies().clear();
                return;
            case SculptormetamodelPackage.SERVICE__SERVICE_DEPENDENCIES:
                getServiceDependencies().clear();
                return;
            case SculptormetamodelPackage.SERVICE__GAP_CLASS:
                setGapClass(GAP_CLASS_EDEFAULT);
                return;
            case SculptormetamodelPackage.SERVICE__WEB_SERVICE:
                setWebService(WEB_SERVICE_EDEFAULT);
                return;
            case SculptormetamodelPackage.SERVICE__REMOTE_INTERFACE:
                setRemoteInterface(REMOTE_INTERFACE_EDEFAULT);
                return;
            case SculptormetamodelPackage.SERVICE__LOCAL_INTERFACE:
                setLocalInterface(LOCAL_INTERFACE_EDEFAULT);
                return;
            case SculptormetamodelPackage.SERVICE__SUBSCRIBE:
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
            case SculptormetamodelPackage.SERVICE__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case SculptormetamodelPackage.SERVICE__REPOSITORY_DEPENDENCIES:
                return repositoryDependencies != null && !repositoryDependencies.isEmpty();
            case SculptormetamodelPackage.SERVICE__MODULE:
                return getModule() != null;
            case SculptormetamodelPackage.SERVICE__OTHER_DEPENDENCIES:
                return otherDependencies != null && !otherDependencies.isEmpty();
            case SculptormetamodelPackage.SERVICE__SERVICE_DEPENDENCIES:
                return serviceDependencies != null && !serviceDependencies.isEmpty();
            case SculptormetamodelPackage.SERVICE__GAP_CLASS:
                return gapClass != GAP_CLASS_EDEFAULT;
            case SculptormetamodelPackage.SERVICE__WEB_SERVICE:
                return webService != WEB_SERVICE_EDEFAULT;
            case SculptormetamodelPackage.SERVICE__REMOTE_INTERFACE:
                return remoteInterface != REMOTE_INTERFACE_EDEFAULT;
            case SculptormetamodelPackage.SERVICE__LOCAL_INTERFACE:
                return localInterface != LOCAL_INTERFACE_EDEFAULT;
            case SculptormetamodelPackage.SERVICE__SUBSCRIBE:
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
        result.append(" (otherDependencies: ");
        result.append(otherDependencies);
        result.append(", gapClass: ");
        result.append(gapClass);
        result.append(", webService: ");
        result.append(webService);
        result.append(", remoteInterface: ");
        result.append(remoteInterface);
        result.append(", localInterface: ");
        result.append(localInterface);
        result.append(')');
        return result.toString();
    }

} //ServiceImpl