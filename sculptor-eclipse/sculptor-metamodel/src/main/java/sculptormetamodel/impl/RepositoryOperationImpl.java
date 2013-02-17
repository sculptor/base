/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import sculptormetamodel.Repository;
import sculptormetamodel.RepositoryOperation;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.RepositoryOperationImpl#isDelegateToAccessObject <em>Delegate To Access Object</em>}</li>
 *   <li>{@link sculptormetamodel.impl.RepositoryOperationImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link sculptormetamodel.impl.RepositoryOperationImpl#getAccessObjectName <em>Access Object Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryOperationImpl extends OperationImpl implements RepositoryOperation {
    /**
     * The default value of the '{@link #isDelegateToAccessObject() <em>Delegate To Access Object</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isDelegateToAccessObject()
     * @generated
     * @ordered
     */
	protected static final boolean DELEGATE_TO_ACCESS_OBJECT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDelegateToAccessObject() <em>Delegate To Access Object</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isDelegateToAccessObject()
     * @generated
     * @ordered
     */
	protected boolean delegateToAccessObject = DELEGATE_TO_ACCESS_OBJECT_EDEFAULT;

    /**
     * The default value of the '{@link #getAccessObjectName() <em>Access Object Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAccessObjectName()
     * @generated
     * @ordered
     */
	protected static final String ACCESS_OBJECT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAccessObjectName() <em>Access Object Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAccessObjectName()
     * @generated
     * @ordered
     */
	protected String accessObjectName = ACCESS_OBJECT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RepositoryOperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.REPOSITORY_OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isDelegateToAccessObject() {
        return delegateToAccessObject;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDelegateToAccessObject(boolean newDelegateToAccessObject) {
        boolean oldDelegateToAccessObject = delegateToAccessObject;
        delegateToAccessObject = newDelegateToAccessObject;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REPOSITORY_OPERATION__DELEGATE_TO_ACCESS_OBJECT, oldDelegateToAccessObject, delegateToAccessObject));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository getRepository() {
        if (eContainerFeatureID() != SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY) return null;
        return (Repository)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRepository, SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRepository(Repository newRepository) {
        if (newRepository != eInternalContainer() || (eContainerFeatureID() != SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY && newRepository != null)) {
            if (EcoreUtil.isAncestor(this, newRepository))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRepository != null)
                msgs = ((InternalEObject)newRepository).eInverseAdd(this, SculptormetamodelPackage.REPOSITORY__OPERATIONS, Repository.class, msgs);
            msgs = basicSetRepository(newRepository, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY, newRepository, newRepository));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getAccessObjectName() {
        return accessObjectName;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAccessObjectName(String newAccessObjectName) {
        String oldAccessObjectName = accessObjectName;
        accessObjectName = newAccessObjectName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REPOSITORY_OPERATION__ACCESS_OBJECT_NAME, oldAccessObjectName, accessObjectName));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRepository((Repository)otherEnd, msgs);
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
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                return basicSetRepository(null, msgs);
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
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                return eInternalContainer().eInverseRemove(this, SculptormetamodelPackage.REPOSITORY__OPERATIONS, Repository.class, msgs);
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
            case SculptormetamodelPackage.REPOSITORY_OPERATION__DELEGATE_TO_ACCESS_OBJECT:
                return isDelegateToAccessObject() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                return getRepository();
            case SculptormetamodelPackage.REPOSITORY_OPERATION__ACCESS_OBJECT_NAME:
                return getAccessObjectName();
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
            case SculptormetamodelPackage.REPOSITORY_OPERATION__DELEGATE_TO_ACCESS_OBJECT:
                setDelegateToAccessObject(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                setRepository((Repository)newValue);
                return;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__ACCESS_OBJECT_NAME:
                setAccessObjectName((String)newValue);
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
            case SculptormetamodelPackage.REPOSITORY_OPERATION__DELEGATE_TO_ACCESS_OBJECT:
                setDelegateToAccessObject(DELEGATE_TO_ACCESS_OBJECT_EDEFAULT);
                return;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                setRepository((Repository)null);
                return;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__ACCESS_OBJECT_NAME:
                setAccessObjectName(ACCESS_OBJECT_NAME_EDEFAULT);
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
            case SculptormetamodelPackage.REPOSITORY_OPERATION__DELEGATE_TO_ACCESS_OBJECT:
                return delegateToAccessObject != DELEGATE_TO_ACCESS_OBJECT_EDEFAULT;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__REPOSITORY:
                return getRepository() != null;
            case SculptormetamodelPackage.REPOSITORY_OPERATION__ACCESS_OBJECT_NAME:
                return ACCESS_OBJECT_NAME_EDEFAULT == null ? accessObjectName != null : !ACCESS_OBJECT_NAME_EDEFAULT.equals(accessObjectName);
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
        result.append(" (delegateToAccessObject: ");
        result.append(delegateToAccessObject);
        result.append(", accessObjectName: ");
        result.append(accessObjectName);
        result.append(')');
        return result.toString();
    }

} //RepositoryOperationImpl