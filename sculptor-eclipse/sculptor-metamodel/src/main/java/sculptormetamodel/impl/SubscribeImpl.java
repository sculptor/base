/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Subscribe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subscribe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.SubscribeImpl#getEventBus <em>Event Bus</em>}</li>
 *   <li>{@link sculptormetamodel.impl.SubscribeImpl#getTopic <em>Topic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubscribeImpl extends EObjectImpl implements Subscribe {
    /**
     * The default value of the '{@link #getEventBus() <em>Event Bus</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventBus()
     * @generated
     * @ordered
     */
    protected static final String EVENT_BUS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEventBus() <em>Event Bus</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventBus()
     * @generated
     * @ordered
     */
    protected String eventBus = EVENT_BUS_EDEFAULT;

    /**
     * The default value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
    protected static final String TOPIC_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
    protected String topic = TOPIC_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SubscribeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.SUBSCRIBE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEventBus() {
        return eventBus;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventBus(String newEventBus) {
        String oldEventBus = eventBus;
        eventBus = newEventBus;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SUBSCRIBE__EVENT_BUS, oldEventBus, eventBus));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTopic(String newTopic) {
        String oldTopic = topic;
        topic = newTopic;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.SUBSCRIBE__TOPIC, oldTopic, topic));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.SUBSCRIBE__EVENT_BUS:
                return getEventBus();
            case SculptormetamodelPackage.SUBSCRIBE__TOPIC:
                return getTopic();
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
            case SculptormetamodelPackage.SUBSCRIBE__EVENT_BUS:
                setEventBus((String)newValue);
                return;
            case SculptormetamodelPackage.SUBSCRIBE__TOPIC:
                setTopic((String)newValue);
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
            case SculptormetamodelPackage.SUBSCRIBE__EVENT_BUS:
                setEventBus(EVENT_BUS_EDEFAULT);
                return;
            case SculptormetamodelPackage.SUBSCRIBE__TOPIC:
                setTopic(TOPIC_EDEFAULT);
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
            case SculptormetamodelPackage.SUBSCRIBE__EVENT_BUS:
                return EVENT_BUS_EDEFAULT == null ? eventBus != null : !EVENT_BUS_EDEFAULT.equals(eventBus);
            case SculptormetamodelPackage.SUBSCRIBE__TOPIC:
                return TOPIC_EDEFAULT == null ? topic != null : !TOPIC_EDEFAULT.equals(topic);
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
        result.append(" (eventBus: ");
        result.append(eventBus);
        result.append(", topic: ");
        result.append(topic);
        result.append(')');
        return result.toString();
    }

} //SubscribeImpl
