/*
 * (C) Copyright Factory4Solutions a.s. 2009 and beyond
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.smartclient.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.rpc.HandleErrorCallback;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.IconClickEvent;
import com.smartgwt.client.widgets.events.IconClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickHandler;

/**
 * SmartClient universal client for sculptor. This is main class used by GWT as entry point.
 * 
 * @author Ing. Pavel Tavoda
 *
 */
public class Main implements EntryPoint {
	public static final boolean DEBUG=true;
	public static final String JAVASCRIPT_PREFIX="javascript:";

	static final boolean allowComet=false;
	static final HashMap<String, String> unitsMap=new HashMap<String, String>();
	static final String SERVICE_NAME="serviceName";
	static final String SERVICE_ACTIONS="serviceActions";
	static SCLayout layout=SCLayout.Tree;

	static UserInfo userInfo=null;

	ListGrid actualGrid = null;
	private ListGrid listGrid = new ListGrid();
	private TreeGrid treeGrid = new TreeGrid();
	Menu contextMenu=new Menu();
	DetailForm mainForm=new DetailForm(this, 10);
	final VLayout detail=new VLayout();
	final SectionStack menuStack = new SectionStack();
	VLayout listPart=new VLayout();
	DataSource emptyDS=new DataSource();
	TreeGrid treeGrids[] = null;
	Label emptyLabel=new Label("HELL");
	ButtonClickHandler listButtonClickHandler=new ButtonClickHandler(this);
	static String serviceUrl="/service";
	static String baseUrl=null;
	Comet comet=new Comet(this);
	final TabSet tabs=new TabSet();

	public void onModuleLoad() {
		int slashOffset=GWT.getModuleBaseURL().lastIndexOf("/", GWT.getModuleBaseURL().length() - 2);
		if (slashOffset == - 1) {
			SC.say("You have to use FULL URL with module name "+GWT.getModuleName());
			return;
		}
		baseUrl=GWT.getModuleBaseURL().substring(0, slashOffset);
		serviceUrl=baseUrl+"/service";

		// Show dev console
		if ("true".equals(Location.getParameter("showConsole")) && DEBUG) {
			SC.showConsole();
		}

		if ("tree".equalsIgnoreCase(Location.getParameter("layout"))) {
			layout=SCLayout.Tree;
		} else if ("tabbed".equalsIgnoreCase(Location.getParameter("layout"))) {
			layout=SCLayout.Tabbed;
		}

		// Defaults
		RPCManager.setFetchDataPrompt("Vyberam data .... pockajte chvilku");
		RPCManager.setSaveDataPrompt("Ukladam .... chvilku pockajte");
		RPCManager.setRemoveDataPrompt("Mazem .... to bude hned hotove");
		RPCManager.setDefaultPrompt("Vasa poziadavka sa spracovava");

		RPCManager.setShowPrompt(true);
		RPCManager.setDefaultTimeout(50000);
		RPCManager.setHandleErrorCallback(new HandleErrorCallback() {
			public void handleError(DSResponse response, DSRequest request) {
				int status = response.getStatus();
				if (status == RPCResponse.STATUS_TRANSPORT_ERROR) {
					SC.ask("Server not responding. Restart?", new BooleanCallback() {
						public void execute(Boolean value) {
							if (value != null && Boolean.TRUE.equals(value)) {
								Location.reload();
							}
						}
					});
				} else {
					SC.warn("Other server error: "+status+" ("+response.getHttpResponseCode()+")");
				}
			}
		});

		Canvas header = getHeader();
		Layout main;
		// Main area
		if (layout.equals(SCLayout.Tabbed)) {
			main = new VLayout();
			main.setLayoutMargin(0);
			main.setWidth100();
			main.setHeight100();
			Canvas mainPanel = getMainPanel();
			main.addMember(getMenu(mainPanel));
		} else {
			main = new HLayout();
			main.setLayoutMargin(0);
			main.setWidth100();
			main.setHeight("*");
			Canvas mainPanel = getMainPanel();
			main.addMember(getMenu(mainPanel));
			main.addMember(mainPanel);
		}

		VLayout mainWindow = new VLayout();
		mainWindow.setWidth100();
		mainWindow.setHeight100();
		mainWindow.addMember(header);
		mainWindow.addMember(main);
		// mainWindow.setBackgroundColor("black");
		mainWindow.draw();

		comet.startComet();
	}

	// Header
	private Canvas getHeader() {
		HLayout header=new HLayout();
		header.setWidth100();
		header.setHeight(35);
		header.setAlign(VerticalAlignment.CENTER);

		Img companyLogo=new Img("logo.png");
		companyLogo.setImageType(ImageStyle.NORMAL);
		companyLogo.setAutoFit(true);
		header.addMember(companyLogo);

		final SelectItem layoutCombo=new SelectItem();
		layoutCombo.setTitle("Layout");
		String[] layoutVals=new String[SCLayout.values().length];
		for (SCLayout val : SCLayout.values()) {
			layoutVals[val.ordinal()]=val.name();
		}
		layoutCombo.setValueMap(layoutVals);
		layoutCombo.setValue(layout.name());

		final SelectItem skinCombo=new SelectItem();
		skinCombo.setTitle("Skin");
		skinCombo.setValueMap("Graphite", "Enterprise", "EnterpriseBlue", "TreeFrog");
		String skinParam = Location.getParameter("skin");
		skinCombo.setDefaultValue(skinParam != null ? skinParam : "Graphite");
		SubmitItem setButton=new SubmitItem();
		setButton.setTitle("Change");
		setButton.setStartRow(false);
		setButton.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				String skin=(String) skinCombo.getValue();
				String layout=(String) layoutCombo.getValue();
				String base=Location.getHref();
				base=(base.indexOf("?") != -1 ? base.substring(0, base.indexOf("?")) : base)+"?";
				if (skin != null) {
					base+="skin="+skin;
				}
				if (layout != null) {
					base+="&layout="+layout;
				}
				Location.replace(base);
			}
		});
		DynamicForm globalForm=new DynamicForm();
		globalForm.setNumCols(7);
		globalForm.setFields(layoutCombo, skinCombo, setButton);
		header.addMember(globalForm);

		final Label userLabel=new Label();
		header.addMember(userLabel);

		Label logout=new Label("");
		logout.setWidth(24);
		logout.setIcon("logout.gif");
		logout.setIconWidth(24);
		logout.setIconHeight(18);
		logout.setIconOrientation("right");
		logout.setPrompt("Logout");
		logout.addIconClickHandler(new IconClickHandler() {
			public void onIconClick(IconClickEvent event) {
				Window.Location.assign(baseUrl+"/logout");
			}
		});
		header.addMember(logout);

		// Request user info
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("_dataSource", "userInfo");
		DSRequest reqProperties=new DSRequest();
		reqProperties.setShowPrompt(true);
		reqProperties.setPrompt("Nacitavam udaje o prihlasenom uzivatelovi");
		reqProperties.setActionURL(serviceUrl);
		reqProperties.setEvalResult(false);
		reqProperties.setParams(params);
		GuiUtil.RPCManagerSend(null, new DSCallback() {
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				if (handleRpcManagerError(rawData)) {
					return;
				}

				if (rawData != null) {
					userInfo=new UserInfo(rawData.toString());
					userLabel.setContents("User:&nbsp;"+userInfo.getUsername()+(userInfo.isUserInRole("ROLE_ADMIN") ? "&nbsp;(admin)" : ""));
				}
			}
		}, reqProperties);

		return header;
	}

	private Canvas getMainPanel() {
		HeaderItem header = new HeaderItem();
		header.setDefaultValue("Detail");

		RecordClickHandler recordClickHandler=new GridClickHandler(this);

		emptyDS.addField(new DataSourceTextField("empty", "Empty"));
		emptyDS.setClientOnly(true);

		treeGrid.setWidth100();
		treeGrid.setHeight100();
		treeGrid.setShowAllRecords(false);
		// treeGrid.setAutoFetchData(true);
		treeGrid.setLoadDataOnDemand(true);
		treeGrid.setShowOpenIcons(false);
		treeGrid.setShowDropIcons(false);
		treeGrid.setClosedIconSuffix("");
		treeGrid.setFolderIcon("16/house.png");
		treeGrid.setNodeIcon("16/person.png");
		treeGrid.setDataPageSize(30);
		treeGrid.setAlternateRecordStyles(true);
		treeGrid.setID("mainListGridTree");
		treeGrid.addRecordClickHandler(recordClickHandler);
		treeGrid.setCanAddFormulaFields(true);
		treeGrid.setCanAddSummaryFields(true);
		treeGrid.setShowFilterEditor(true);
		treeGrid.setSelectionType(SelectionStyle.SIMPLE);
		treeGrid.setDataSource(emptyDS);
		treeGrid.hide();

		listGrid.setWidth100();
		listGrid.setHeight100();
		listGrid.setShowAllRecords(false);
		// listGrid.setAutoFetchData(true);
		listGrid.setDataPageSize(30);
		listGrid.setAlternateRecordStyles(true);
		listGrid.setID("mainListGrid");
		listGrid.addRecordClickHandler(recordClickHandler);
		listGrid.setShowDetailFields(false);
		listGrid.setShowFilterEditor(true);
		listGrid.setCanAddFormulaFields(true);
		listGrid.setCanAddSummaryFields(true);
		listGrid.setSelectionType(SelectionStyle.SIMPLE);
		listGrid.setDataSource(emptyDS);
		actualGrid=listGrid;

		MenuItem saveStatus=new MenuItem("Save status");
		saveStatus.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				try {
					String viewState=actualGrid.getFieldState();

					HashMap<String, String> params=new HashMap<String, String>();
					params.put("_dataSource", "listSettingsService");
					params.put("_operationType", "add");
					params.put("listID", actualGrid.getDataSource().getID());
					params.put("settings", viewState);
					params.put("userName", userInfo.getUsername());

					DSRequest reqProperties=new DSRequest();
					reqProperties.setShowPrompt(true);
					reqProperties.setPrompt("Saving status");
					reqProperties.setActionURL(serviceUrl);
					reqProperties.setParams(params);
					GuiUtil.RPCManagerSend(null, new DSCallback() {
						public void execute(DSResponse response, Object rawData, DSRequest request) {
							// SC.say("RESPONSE "+response.getStatus());
						}
					}, reqProperties);
				} catch (Exception ex) {
					GWT.log("error!!!", ex);
				}
			}
		});
		MenuItem refetchData=new MenuItem("Refetch data");
		refetchData.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				try {
					actualGrid.invalidateCache();
				} catch (Exception ex) {
					GWT.log("error!!!", ex);
				}
			}
		});

		MenuItem exportData=new MenuItem("Export");
		exportData.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				try {
					Window.open(serviceUrl+"?_dataSource="+actualGrid.getDataSource().getID()+"&_operationType=export", "upload", "");
				} catch (Exception ex) {
					GWT.log("error!!!", ex);
				}
			}
		});

		MenuItem importData=new MenuItem("Import");
		importData.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			public void onClick(MenuItemClickEvent event) {
				try {
				} catch (Exception ex) {
					GWT.log("error!!!", ex);
				}
			}
		});

		MenuItemSeparator menuSeparator=new MenuItemSeparator();
		contextMenu.setData(saveStatus, refetchData, menuSeparator, exportData, importData);
		listGrid.setContextMenu(contextMenu);
		treeGrid.setContextMenu(contextMenu);

		/*
		Canvas topList=new Canvas();
		topList.setShowResizeBar(true);
		topList.addChild(listGrid); //.addChild(treeGrid);
		topList.setWidth100();
		topList.setHeight100();
		*/
		Canvas gridContainer=new Canvas();
		gridContainer.setWidth100();
		gridContainer.setHeight100();
		gridContainer.addChild(listGrid);
		gridContainer.addChild(treeGrid);
		listPart.setWidth100();
		listPart.setHeight100();
		listPart.addMember(gridContainer);
		listPart.setShowResizeBar(true);

		detail.addMember(listPart);
		detail.addMember(mainForm);

		return detail;
	}

	private Widget getMenu(Canvas mainPanel) {
		if (layout.equals(SCLayout.Tabbed)) {
			return getMenuTabs(mainPanel);
		} else {
			return getMenuStack();
		}
	}

	boolean skipSubhandler=false;

	private Widget getMenuTabs(Canvas mainPanel) {
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("_dataSource", "getMenu");


		final TabSelectedHandler tabSubSectionHandler=new TabSelectedHandler() {
			public void onTabSelected(TabSelectedEvent event) {
				if (!skipSubhandler) {
					showDataSource(event.getTab().getAttributeAsJavaScriptObject(Main.SERVICE_ACTIONS), event.getTab().getAttribute(Main.SERVICE_NAME));
				}
				skipSubhandler=false;
				/*
				event.getTab().setPane(detail);
				detail.show();
				detail.markForRedraw();
				mainForm.show();
				mainForm.markForRedraw();
				actualGrid.show();
				*/
			}
		};

		DSRequest reqProperties=new DSRequest();
		reqProperties.setShowPrompt(true);
		reqProperties.setPrompt("Nacitavam menu&nbsp;...&nbsp;pockajte chvilku");
		reqProperties.setActionURL(serviceUrl);
		reqProperties.setEvalResult(true);
		reqProperties.setParams(params);
		GuiUtil.RPCManagerSend(null, new DSCallback() {
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				if (handleRpcManagerError(rawData)) {
					return;
				}

				JavaScriptObject[] sectionArray = JSOHelper.toArray((JavaScriptObject) rawData);
				Tab[] tabSections=new Tab[sectionArray.length];
				treeGrids = new TreeGrid[0];
				for (int k=0; k <  sectionArray.length; k++) {
					JavaScriptObject section=sectionArray[k];

					int arrLength = JSOHelper.getArrayLength(section);
					Tab[] subTabs=new Tab[arrLength / 3];
					String serviceName=null;
					JavaScriptObject serviceActions=null;
					// Skip first
					for (int i=1; i < arrLength; i++) {
						if (i%3 == 1) {
							serviceName=JSOHelper.getArrayValue(section, i);
						} else if (i%3 == 2) {
							serviceActions=JSOHelper.getValueFromJavaScriptObjectArray(section, i);
						} else {
							int offset=i/3 - 1;
							subTabs[offset]=new Tab(JSOHelper.getArrayValue(section, i));
							subTabs[offset].setAttribute(SERVICE_NAME, serviceName);
							subTabs[offset].setAttribute(SERVICE_ACTIONS, serviceActions);
							subTabs[offset].setPane(detail);
						}
					}

					TabSet tabSubSection=new TabSet();
					tabSubSection.setWidth100();
					tabSubSection.setTabs(subTabs);
					tabSubSection.addTabSelectedHandler(tabSubSectionHandler);

					Tab tabSection=new Tab(JSOHelper.getArrayValue(section, 0));
					tabSection.setPane(tabSubSection);
					tabSections[k]=tabSection;
				}
				tabs.setTabs(tabSections);
				tabs.addTabSelectedHandler(new TabSelectedHandler() {
					public void onTabSelected(TabSelectedEvent event) {
						TabSet selectedTabSet=(TabSet) event.getTabPane();
						// selectedTabSet.draw();
						Tab selectedTab = selectedTabSet.getSelectedTab();

						/*
						selectedTab.setPane(detail);
						selectedTabSet.setVisible(true);
						selectedTabSet.show();
						selectedTabSet.markForRedraw();
						detail.setVisible(true);
						detail.show();
						detail.markForRedraw();

						selectedTabSet.updateTab(selectedTab, emptyLabel);
						selectedTabSet.updateTab(selectedTab, detail);
						*/

						int selTab=selectedTabSet.getSelectedTabNumber();
						selectedTabSet.selectTab(selTab == 0 ? 1 : 0);
						selectedTabSet.selectTab(selTab);

						skipSubhandler=true;
						showDataSource(selectedTab.getAttributeAsJavaScriptObject(Main.SERVICE_ACTIONS), selectedTab.getAttribute(Main.SERVICE_NAME));

						// mainForm.alignButtons(selectedTab.getAttributeAsJavaScriptObject(SERVICE_ACTIONS), selectedTab.getAttribute(SERVICE_NAME));
						// actualGrid.show();
					}
				});
			}
		}, reqProperties);
		return tabs;
	}

	private Widget getMenuStack() {
		final SectionStack menuStack = new SectionStack();
		menuStack.setWidth("18%");
		menuStack.setHeight100();
		menuStack.setVisibilityMode(VisibilityMode.MULTIPLE);
		// menuStack.setOverflow(Overflow.HIDDEN);
		menuStack.setShowResizeBar(true);
		menuStack.setAnimateSections(true);

		HashMap<String, String> params=new HashMap<String, String>();
		params.put("_dataSource", "getMenu");

		final NodeClickHandler treeNodeClickHandler=new NodeClickHandler() {
			public void onNodeClick(NodeClickEvent event) {
				for (TreeGrid treeGrid : treeGrids) {
					ListGridRecord sRecord = treeGrid.getSelectedRecord();
					if (sRecord != null && !event.getViewer().equals(treeGrid)) {
						treeGrid.selectRecord(sRecord, false);
					}
				}
				showDataSource(event.getNode().getAttributeAsJavaScriptObject(Main.SERVICE_ACTIONS), event.getNode().getAttribute(Main.SERVICE_NAME));
			}
		};

		DSRequest reqProperties=new DSRequest();
		reqProperties.setShowPrompt(true);
		reqProperties.setPrompt("Nacitavam menu&nbsp;...&nbsp;pockajte chvilku");
		reqProperties.setActionURL(serviceUrl);
		reqProperties.setEvalResult(true);
		reqProperties.setParams(params);
		GuiUtil.RPCManagerSend(null, new DSCallback() {
			public void execute(DSResponse response, Object rawData, DSRequest request) {
				if (handleRpcManagerError(rawData)) {
					return;
				}

				JavaScriptObject[] sectionArray = JSOHelper.toArray((JavaScriptObject) rawData);
				SectionStackSection[] guiSections=new SectionStackSection[sectionArray.length];
				treeGrids = new TreeGrid[sectionArray.length];
				for (int k=0; k <  sectionArray.length; k++) {
					JavaScriptObject section=sectionArray[k];

					int arrLength = JSOHelper.getArrayLength(section);
					TreeNode[] nodes=new TreeNode[arrLength / 3];
					String serviceName=null;
					JavaScriptObject serviceActions=null;
					// Skip first
					for (int i=1; i < arrLength; i++) {
						if (i%3 == 1) {
							serviceName=JSOHelper.getArrayValue(section, i);
						} else if (i%3 == 2) {
							serviceActions=JSOHelper.getValueFromJavaScriptObjectArray(section, i);
						} else {
							int offset=i/3 - 1;
							nodes[offset]=new TreeNode(JSOHelper.getArrayValue(section, i));
							nodes[offset].setAttribute(SERVICE_NAME, serviceName);
							nodes[offset].setAttribute(SERVICE_ACTIONS, serviceActions);
						}
					}

					Tree tree = new Tree();
					tree.setModelType(TreeModelType.CHILDREN);
					tree.setRoot(new TreeNode("root", nodes));

					TreeGrid treeGrid = new TreeGrid();
					treeGrid.setData(tree);
					treeGrid.setShowHeader(false);
					treeGrid.setAlternateRecordStyles(false);
					treeGrid.setShowAllRecords(true);
					treeGrid.setLeaveScrollbarGap(false);
					treeGrid.addNodeClickHandler(treeNodeClickHandler);
					treeGrids[k]=treeGrid;

					SectionStackSection stackSection = new SectionStackSection();
					stackSection.setTitle(JSOHelper.getArrayValue(section, 0));
					// stackSection.setExpanded(true);
					stackSection.setItems(treeGrid);

					guiSections[k]=stackSection;
				}
				menuStack.setSections(guiSections);
			}
		}, reqProperties);

		return menuStack;
	}

	private HashMap<String, String> dataDef=null;

	public void showDataSource(final JavaScriptObject guiProps, final String name) {
		GWT.log("Datasource "+name+(dataDef == null ? " fetching from server" : " using local"), null);
		if (dataDef == null) {
			// This is here because before it get's replaced by defaults
			GuiUtil.setShortDayNames("Ne", "Po", "Ut", "St", "Sv", "Pi", "So");
			GuiUtil.setShortMonthNames("Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec");
			GuiUtil.setDateChooserLocalization("Dnes", "Zrus");

			HashMap<String, String> params=new HashMap<String, String>();
			params.put("_dataSource", "createDataSource");

			DSRequest reqProperties=new DSRequest();
			reqProperties.setShowPrompt(true);
			reqProperties.setPrompt("Nacitavam struktury udajov&nbsp;...&nbsp;pockajte chvilku");
			reqProperties.setActionURL(serviceUrl);
			reqProperties.setParams(params);
			GuiUtil.RPCManagerSend(null, new DSCallback() {
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					if (handleRpcManagerError(rawData)) {
						return;
					}

					dataDef=new HashMap<String, String>();
					String respText=rawData.toString();
					String [] resultArray=respText.split("###");
					for (int i=0; i < resultArray.length; i+=2) {
						dataDef.put(resultArray[i], resultArray[i+1]);
					}

					String dataSources=dataDef.remove("dataSources");
					int lastIndex=0;
					while (lastIndex != -1) {
						int newIndex = dataSources.indexOf("$wnd.isc", lastIndex+1);
						String subDS=dataSources.substring(lastIndex, newIndex != -1 ? newIndex : dataSources.length()-1);
						try {
							GuiUtil.getStringAsJavaScriptObject(subDS);
						} catch (Throwable th) {
							GWT.log("Error '"+th.getMessage()+"' when evaluating: " + subDS, null);
						}
						lastIndex=newIndex;
					}
					refreshScreen(guiProps, name);
				}
			}, reqProperties);
		} else {
			refreshScreen(guiProps, name);
		}
	}

	private void refreshScreen(JavaScriptObject guiProps, String name) {
		comet.startComet();

		actualGrid.clearSort();
		actualGrid.clearCriteria();
		// actualGrid.fetchData();

		// Store current state
		if (actualGrid.getDataSource() != null && actualGrid.getDataSource().getID() != null) {
			String dsName=actualGrid.getDataSource().getID();
			// Set same datasource - don't show it
			if (dsName.equals(name)) {
				return;
			}
			dataDef.put(dsName, actualGrid.getFieldState());
		}

		DataSource ds=DataSource.getDataSource(name);
		JavaScriptObject dsJs = ds.getJsObj();
		// GWT.log("DataSource: "+GuiUtil.getVariableValue(dsJs), null);
		// actualGrid.hide();
		actualGrid.hide();
		String isTree = JSOHelper.getAttribute(dsJs, "isTree");
		if (isTree != null && isTree.equals("true")) {
			GWT.log("Switching to tree grid", null);

			String isLoadAllData = JSOHelper.getAttribute(dsJs, "loadAllData");
			if ("true".equalsIgnoreCase(isLoadAllData)) {
				treeGrid.setLoadDataOnDemand(false);
			} else {
				treeGrid.setLoadDataOnDemand(true);
			}
			treeGrid.setDataSource(ds);

			String folderIcon=JSOHelper.getAttribute(dsJs, "folderIcon");
			String nodeIcon=JSOHelper.getAttribute(dsJs, "nodeIcon");
			treeGrid.setFolderIcon(folderIcon != null ? folderIcon : "16/house.png");
			treeGrid.setNodeIcon(nodeIcon != null ? nodeIcon : treeGrid.getFolderIcon());

			ArrayList<TreeGridField> treeFields=new ArrayList<TreeGridField>();
			JavaScriptObject fieldNames = GuiUtil.getFieldNames(ds);
			for (int i=0;  i < JSOHelper.getArrayLength(fieldNames); i++) {
				DataSourceField field = ds.getField(JSOHelper.getArrayValue(fieldNames, i));
				if (!field.getHidden()) {
					treeFields.add(new TreeGridField(field.getName()));
				}
			}
			treeGrid.setFields(treeFields.toArray(new TreeGridField[treeFields.size()]));
			actualGrid=treeGrid;
		} else {
			GWT.log("Switching to list grid", null);
			listGrid.setDataSource(ds);
			actualGrid=listGrid;
		}
		actualGrid.show();
		actualGrid.markForRedraw();

		Canvas[] members = listPart.getMembers();
		if (members.length > 1) {
			for (Canvas c : ((HLayout) members[1]).getMembers()) {
				c.markForDestroy();
			}
			listPart.removeMember(members[1]);
			members[1].markForDestroy();
		}

		HLayout listButtons=new HLayout(5);
		listButtons.setAlign(Alignment.RIGHT);
		boolean hasButtons=false;
		boolean needSelection=false;
		for (int u=0; u < JSOHelper.getArrayLength(guiProps); u++) {
			JavaScriptObject guiProp = JSOHelper.getValueFromJavaScriptObjectArray(guiProps, u);
			String visibleOn = JSOHelper.getAttribute(guiProp, "visibleOn");
			if (visibleOn != null  && visibleOn.contains("_LIST")) {
				Button listButton=new Button(JSOHelper.getAttribute(guiProp, "guiName"));
				listButton.setAutoFit(true);
				listButton.addClickHandler(listButtonClickHandler);
				JSOHelper.setAttribute(listButton.getConfig(), DetailButtons.GUI_PROPS, guiProp);
				listButtons.addMember(listButton);
				hasButtons=true;
				needSelection = needSelection || listButtonClickHandler.needSelection(guiProp);
			}
		}

		if (hasButtons) {
			if (needSelection) {
				actualGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
				actualGrid.setSelectionType(SelectionStyle.SIMPLE);
			} else {
				actualGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
				actualGrid.setSelectionType(SelectionStyle.SINGLE);
			}
			listPart.addMember(listButtons);
		} else {
			actualGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
			actualGrid.setSelectionType(SelectionStyle.SINGLE);
		}
		listPart.markForRedraw();

		String alternateRecordStyles=JSOHelper.getAttribute(dsJs, "alternateRecordStyles");
		actualGrid.setAlternateRecordStyles(alternateRecordStyles != null ? "true".equals(alternateRecordStyles) : true);
		String canAddFields=JSOHelper.getAttribute(dsJs, "canAddFields");
		actualGrid.setCanAddFormulaFields(canAddFields != null ? "true".equals(canAddFields) : true);
		actualGrid.setCanAddSummaryFields(canAddFields != null ? "true".equals(canAddFields) : true);

		String listGridConfig=dataDef.get(name);
		if (listGridConfig != null) {
			GWT.log("Setting config for '"+name+"'", null);
			try {
				actualGrid.setFieldState(listGridConfig);
			} catch (Throwable th) {
				GWT.log("setFieldState error", th);
			}
		}

		mainForm.setDataSource(guiProps, ds);
		actualGrid.fetchData();
	}

	boolean handleRpcManagerError(Object rawData) {
		try {
			if (JSOHelper.getAttributeAsInt(JSOHelper.getAttributeAsJavaScriptObject((JavaScriptObject) rawData, "response"), "status") != 0) {
				String errorText=JSOHelper.getAttribute(JSOHelper.getAttributeAsJavaScriptObject((JavaScriptObject) rawData, "response"), "data");
				SC.say(errorText);
				GWT.log("ERROR: "+errorText, null);
				return true;
			}
		} catch (Throwable th) {
			// Ignore error - element response.status not available
			GWT.log("ALERT: "+th.getMessage());
		}
		return false;
	}
}

enum SCLayout {
	Tree,
	Tabbed
}

enum GridComponent {
	Tree,
	List
}

class ButtonClickHandler implements ClickHandler {

	private Main main;
	public ButtonClickHandler(Main main) {
		this.main=main;
	}

	public void onClick(ClickEvent event) {
		Button actionButton=(Button) event.getSource();
		JavaScriptObject guiProps = JSOHelper.getAttributeAsJavaScriptObject(actionButton.getConfig(), DetailButtons.GUI_PROPS);
		String action=JSOHelper.getAttribute(guiProps, "doAction");
		if (action!=null && action.startsWith(Main.JAVASCRIPT_PREFIX)) {
			try {
				String execCode=action.substring(Main.JAVASCRIPT_PREFIX.length());
				GWT.log("executing javascript: "+execCode, null);
				GuiUtil.getStringAsJavaScriptObject(execCode);
			} catch (Throwable th) {
				GWT.log("Evaluation error", th);
				SC.say(th.getMessage());
			}
		} else if ("debug".equals(action)) {
			DebugWindow debugWin=new DebugWindow();
			debugWin.show();
		} else {
			try {
				JavaScriptObject guiProp = JSOHelper.getAttributeAsJavaScriptObject(actionButton.getConfig(), DetailButtons.GUI_PROPS);
				String methodName=JSOHelper.getAttribute(guiProp, "methodName");
				String guiName=JSOHelper.getAttribute(guiProp, "guiName");

				DSRequest serverReq=new DSRequest();
				serverReq.setOperationId(methodName);
				serverReq.setPrompt("Executing list action "+guiName);
				if (needSelection(guiProp)) {
					ListGridRecord[] selection = main.actualGrid.getSelection();
					if (selection == null || selection.length == 0) {
						SC.say("Some row(s) have to be selected");
						return;
					}
					StringBuilder strb=null;
					for (int i=0; i < selection.length; i++) {
						if (strb==null) {
							strb=new StringBuilder();
						} else {
							strb.append(",");
						}
						strb.append(selection[i].getAttributeAsInt("id"));
					}
					HashMap<String, String> dt = new HashMap<String, String>();
					dt.put("ids", strb.toString());
					serverReq.setData(dt);
				}
				main.mainForm.saveData(new DSCallback() {
					public void execute(DSResponse response, Object rawData, DSRequest request) {
						main.handleRpcManagerError(rawData);
					}
				}, serverReq);
			} catch (Throwable th) {
				GWT.log("Execute command error", th);
			}
		}
	}

	public boolean needSelection(JavaScriptObject guiProp) {
		String[] parameterNames = JSOHelper.getAttributeAsStringArray(guiProp, "parameterNames");
		if (parameterNames != null) {
			return ("ctx".equals(parameterNames[0]) && parameterNames.length > 1)
					|| (!"ctx".equals(parameterNames[0]) && parameterNames.length > 0);
		}
		return false;
	}

}