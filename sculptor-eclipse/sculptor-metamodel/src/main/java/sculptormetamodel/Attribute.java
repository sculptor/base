/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Attribute#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#isNullable <em>Nullable</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#isNaturalKey <em>Natural Key</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#isRequired <em>Required</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#getLength <em>Length</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#isIndex <em>Index</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#getDatabaseColumn <em>Database Column</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#getValidate <em>Validate</em>}</li>
 *   <li>{@link sculptormetamodel.Attribute#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends TypedElement {
    /**
     * Returns the value of the '<em><b>Changeable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Changeable</em>' attribute.
     * @see #setChangeable(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Changeable()
     * @model default="true"
     * @generated
     */
	boolean isChangeable();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#isChangeable <em>Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Changeable</em>' attribute.
     * @see #isChangeable()
     * @generated
     */
	void setChangeable(boolean value);

    /**
     * Returns the value of the '<em><b>Database Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Database Type</em>' attribute.
     * @see #setDatabaseType(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_DatabaseType()
     * @model
     * @generated
     */
	String getDatabaseType();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#getDatabaseType <em>Database Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Type</em>' attribute.
     * @see #getDatabaseType()
     * @generated
     */
	void setDatabaseType(String value);

    /**
     * Returns the value of the '<em><b>Nullable</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Nullable</em>' attribute.
     * @see #setNullable(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Nullable()
     * @model
     * @generated
     */
	boolean isNullable();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#isNullable <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nullable</em>' attribute.
     * @see #isNullable()
     * @generated
     */
	void setNullable(boolean value);

    /**
     * Returns the value of the '<em><b>Natural Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Natural Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Natural Key</em>' attribute.
     * @see #setNaturalKey(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_NaturalKey()
     * @model
     * @generated
     */
	boolean isNaturalKey();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#isNaturalKey <em>Natural Key</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Natural Key</em>' attribute.
     * @see #isNaturalKey()
     * @generated
     */
	void setNaturalKey(boolean value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see #setVisibility(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Visibility()
     * @model
     * @generated
     */
	String getVisibility();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
	void setVisibility(String value);

    /**
     * Returns the value of the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Required</em>' attribute.
     * @see #setRequired(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Required()
     * @model
     * @generated
     */
	boolean isRequired();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#isRequired <em>Required</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required</em>' attribute.
     * @see #isRequired()
     * @generated
     */
	void setRequired(boolean value);

    /**
     * Returns the value of the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Length</em>' attribute.
     * @see #setLength(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Length()
     * @model
     * @generated
     */
    String getLength();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#getLength <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Length</em>' attribute.
     * @see #getLength()
     * @generated
     */
    void setLength(String value);

    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Index()
     * @model
     * @generated
     */
    boolean isIndex();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#isIndex <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Index</em>' attribute.
     * @see #isIndex()
     * @generated
     */
    void setIndex(boolean value);

    /**
     * Returns the value of the '<em><b>Database Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Column</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database Column</em>' attribute.
     * @see #setDatabaseColumn(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_DatabaseColumn()
     * @model
     * @generated
     */
    String getDatabaseColumn();

    /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#getDatabaseColumn <em>Database Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Column</em>' attribute.
     * @see #getDatabaseColumn()
     * @generated
     */
    void setDatabaseColumn(String value);

				/**
     * Returns the value of the '<em><b>Validate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Validate</em>' attribute.
     * @see #setValidate(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Validate()
     * @model
     * @generated
     */
	String getValidate();

				/**
     * Sets the value of the '{@link sculptormetamodel.Attribute#getValidate <em>Validate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Validate</em>' attribute.
     * @see #getValidate()
     * @generated
     */
	void setValidate(String value);

				/**
     * Returns the value of the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transient</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transient</em>' attribute.
     * @see #setTransient(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getAttribute_Transient()
     * @model
     * @generated
     */
    boolean isTransient();

                /**
     * Sets the value of the '{@link sculptormetamodel.Attribute#isTransient <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transient</em>' attribute.
     * @see #isTransient()
     * @generated
     */
    void setTransient(boolean value);

} // Attribute