/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Application#getBasePackage <em>Base Package</em>}</li>
 *   <li>{@link sculptormetamodel.Application#getModules <em>Modules</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
    /**
     * Returns the value of the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Package</em>' attribute.
     * @see #setBasePackage(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getApplication_BasePackage()
     * @model
     * @generated
     */
	String getBasePackage();

    /**
     * Sets the value of the '{@link sculptormetamodel.Application#getBasePackage <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Package</em>' attribute.
     * @see #getBasePackage()
     * @generated
     */
	void setBasePackage(String value);

    /**
     * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
     * The list contents are of type {@link sculptormetamodel.Module}.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.Module#getApplication <em>Application</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Modules</em>' containment reference list.
     * @see sculptormetamodel.SculptormetamodelPackage#getApplication_Modules()
     * @see sculptormetamodel.Module#getApplication
     * @model type="sculptormetamodel.Module" opposite="application" containment="true"
     * @generated
     */
	EList getModules();

} // Application