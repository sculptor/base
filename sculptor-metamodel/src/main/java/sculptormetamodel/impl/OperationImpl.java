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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptormetamodel.Operation;
import sculptormetamodel.Parameter;
import sculptormetamodel.Publish;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.OperationImpl#getThrows <em>Throws</em>}</li>
 *   <li>{@link sculptormetamodel.impl.OperationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link sculptormetamodel.impl.OperationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link sculptormetamodel.impl.OperationImpl#getPublish <em>Publish</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends DomainObjectTypedElementImpl implements Operation {
    /**
     * The default value of the '{@link #getThrows() <em>Throws</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getThrows()
     * @generated
     * @ordered
     */
	protected static final String THROWS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getThrows() <em>Throws</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getThrows()
     * @generated
     * @ordered
     */
	protected String throws_ = THROWS_EDEFAULT;

    /**
     * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
	protected static final String VISIBILITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
	protected String visibility = VISIBILITY_EDEFAULT;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
	protected EList parameters;

    /**
     * The cached value of the '{@link #getPublish() <em>Publish</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPublish()
     * @generated
     * @ordered
     */
    protected Publish publish;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.OPERATION;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getThrows() {
        return throws_;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setThrows(String newThrows) {
        String oldThrows = throws_;
        throws_ = newThrows;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.OPERATION__THROWS, oldThrows, throws_));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVisibility(String newVisibility) {
        String oldVisibility = visibility;
        visibility = newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.OPERATION__VISIBILITY, oldVisibility, visibility));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentEList(Parameter.class, this, SculptormetamodelPackage.OPERATION__PARAMETERS);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Publish getPublish() {
        if (publish != null && publish.eIsProxy()) {
            InternalEObject oldPublish = (InternalEObject)publish;
            publish = (Publish)eResolveProxy(oldPublish);
            if (publish != oldPublish) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.OPERATION__PUBLISH, oldPublish, publish));
            }
        }
        return publish;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Publish basicGetPublish() {
        return publish;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPublish(Publish newPublish) {
        Publish oldPublish = publish;
        publish = newPublish;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.OPERATION__PUBLISH, oldPublish, publish));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.OPERATION__PARAMETERS:
                return ((InternalEList)getParameters()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.OPERATION__THROWS:
                return getThrows();
            case SculptormetamodelPackage.OPERATION__VISIBILITY:
                return getVisibility();
            case SculptormetamodelPackage.OPERATION__PARAMETERS:
                return getParameters();
            case SculptormetamodelPackage.OPERATION__PUBLISH:
                if (resolve) return getPublish();
                return basicGetPublish();
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
            case SculptormetamodelPackage.OPERATION__THROWS:
                setThrows((String)newValue);
                return;
            case SculptormetamodelPackage.OPERATION__VISIBILITY:
                setVisibility((String)newValue);
                return;
            case SculptormetamodelPackage.OPERATION__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.OPERATION__PUBLISH:
                setPublish((Publish)newValue);
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
            case SculptormetamodelPackage.OPERATION__THROWS:
                setThrows(THROWS_EDEFAULT);
                return;
            case SculptormetamodelPackage.OPERATION__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case SculptormetamodelPackage.OPERATION__PARAMETERS:
                getParameters().clear();
                return;
            case SculptormetamodelPackage.OPERATION__PUBLISH:
                setPublish((Publish)null);
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
            case SculptormetamodelPackage.OPERATION__THROWS:
                return THROWS_EDEFAULT == null ? throws_ != null : !THROWS_EDEFAULT.equals(throws_);
            case SculptormetamodelPackage.OPERATION__VISIBILITY:
                return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
            case SculptormetamodelPackage.OPERATION__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case SculptormetamodelPackage.OPERATION__PUBLISH:
                return publish != null;
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
        result.append(" (throws: ");
        result.append(throws_);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(')');
        return result.toString();
    }

} //OperationImpl