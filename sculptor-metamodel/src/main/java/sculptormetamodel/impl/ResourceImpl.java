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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptormetamodel.Module;
import sculptormetamodel.Resource;
import sculptormetamodel.ResourceOperation;
import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.ResourceImpl#getServiceDependencies <em>Service Dependencies</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ResourceImpl#isGapClass <em>Gap Class</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ResourceImpl#getPath <em>Path</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ResourceImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ResourceImpl#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceImpl extends NamedElementImpl implements Resource {
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
     * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPath()
     * @generated
     * @ordered
     */
    protected static final String PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPath()
     * @generated
     * @ordered
     */
    protected String path = PATH_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.RESOURCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getServiceDependencies() {
        if (serviceDependencies == null) {
            serviceDependencies = new EObjectResolvingEList(Service.class, this, SculptormetamodelPackage.RESOURCE__SERVICE_DEPENDENCIES);
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.RESOURCE__GAP_CLASS, oldGapClass, gapClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPath() {
        return path;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPath(String newPath) {
        String oldPath = path;
        path = newPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.RESOURCE__PATH, oldPath, path));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentWithInverseEList(ResourceOperation.class, this, SculptormetamodelPackage.RESOURCE__OPERATIONS, SculptormetamodelPackage.RESOURCE_OPERATION__RESOURCE);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Module getModule() {
        if (eContainerFeatureID() != SculptormetamodelPackage.RESOURCE__MODULE) return null;
        return (Module)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newModule, SculptormetamodelPackage.RESOURCE__MODULE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModule(Module newModule) {
        if (newModule != eInternalContainer() || (eContainerFeatureID() != SculptormetamodelPackage.RESOURCE__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newModule != null)
                msgs = ((InternalEObject)newModule).eInverseAdd(this, SculptormetamodelPackage.MODULE__RESOURCES, Module.class, msgs);
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.RESOURCE__MODULE, newModule, newModule));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.RESOURCE__OPERATIONS:
                return ((InternalEList)getOperations()).basicAdd(otherEnd, msgs);
            case SculptormetamodelPackage.RESOURCE__MODULE:
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
            case SculptormetamodelPackage.RESOURCE__OPERATIONS:
                return ((InternalEList)getOperations()).basicRemove(otherEnd, msgs);
            case SculptormetamodelPackage.RESOURCE__MODULE:
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
            case SculptormetamodelPackage.RESOURCE__MODULE:
                return eInternalContainer().eInverseRemove(this, SculptormetamodelPackage.MODULE__RESOURCES, Module.class, msgs);
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
            case SculptormetamodelPackage.RESOURCE__SERVICE_DEPENDENCIES:
                return getServiceDependencies();
            case SculptormetamodelPackage.RESOURCE__GAP_CLASS:
                return isGapClass() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.RESOURCE__PATH:
                return getPath();
            case SculptormetamodelPackage.RESOURCE__OPERATIONS:
                return getOperations();
            case SculptormetamodelPackage.RESOURCE__MODULE:
                return getModule();
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
            case SculptormetamodelPackage.RESOURCE__SERVICE_DEPENDENCIES:
                getServiceDependencies().clear();
                getServiceDependencies().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.RESOURCE__GAP_CLASS:
                setGapClass(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.RESOURCE__PATH:
                setPath((String)newValue);
                return;
            case SculptormetamodelPackage.RESOURCE__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.RESOURCE__MODULE:
                setModule((Module)newValue);
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
            case SculptormetamodelPackage.RESOURCE__SERVICE_DEPENDENCIES:
                getServiceDependencies().clear();
                return;
            case SculptormetamodelPackage.RESOURCE__GAP_CLASS:
                setGapClass(GAP_CLASS_EDEFAULT);
                return;
            case SculptormetamodelPackage.RESOURCE__PATH:
                setPath(PATH_EDEFAULT);
                return;
            case SculptormetamodelPackage.RESOURCE__OPERATIONS:
                getOperations().clear();
                return;
            case SculptormetamodelPackage.RESOURCE__MODULE:
                setModule((Module)null);
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
            case SculptormetamodelPackage.RESOURCE__SERVICE_DEPENDENCIES:
                return serviceDependencies != null && !serviceDependencies.isEmpty();
            case SculptormetamodelPackage.RESOURCE__GAP_CLASS:
                return gapClass != GAP_CLASS_EDEFAULT;
            case SculptormetamodelPackage.RESOURCE__PATH:
                return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
            case SculptormetamodelPackage.RESOURCE__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case SculptormetamodelPackage.RESOURCE__MODULE:
                return getModule() != null;
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
        result.append(" (gapClass: ");
        result.append(gapClass);
        result.append(", path: ");
        result.append(path);
        result.append(')');
        return result.toString();
    }

} //ResourceImpl
