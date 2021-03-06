package nc.ui.so.mreturnpolicy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class returnpolicy_org_config extends AbstractJavaBeanDefinition{
	private Map<String, Object> context = new HashMap();
public nc.vo.uif2.LoginContext getContext(){
 if(context.get("context")!=null)
 return (nc.vo.uif2.LoginContext)context.get("context");
  nc.vo.uif2.LoginContext bean = new nc.vo.uif2.LoginContext();
  context.put("context",bean);
  bean.setNodeType(nc.vo.bd.pub.NODE_TYPE.ORG_NODE);
return bean;
}

public nc.ui.pubapp.pub.smart.SmartBatchAppModelService getBatchModelService(){
 if(context.get("batchModelService")!=null)
 return (nc.ui.pubapp.pub.smart.SmartBatchAppModelService)context.get("batchModelService");
  nc.ui.pubapp.pub.smart.SmartBatchAppModelService bean = new nc.ui.pubapp.pub.smart.SmartBatchAppModelService();
  context.put("batchModelService",bean);
  bean.setVoClass("nc.vo.so.mreturnpolicy.entity.ReturnPolicyVO");
  bean.setServiceItf("nc.itf.so.mreturnpolicy.IReturnPolicyMaintain");
return bean;
}

public nc.vo.bd.meta.BDObjectAdpaterFactory getBoadatorfactory(){
 if(context.get("boadatorfactory")!=null)
 return (nc.vo.bd.meta.BDObjectAdpaterFactory)context.get("boadatorfactory");
  nc.vo.bd.meta.BDObjectAdpaterFactory bean = new nc.vo.bd.meta.BDObjectAdpaterFactory();
  context.put("boadatorfactory",bean);
return bean;
}

public nc.ui.so.mreturnpolicy.model.ReturnPolicyValidationService getBatchValidateSerice(){
 if(context.get("batchValidateSerice")!=null)
 return (nc.ui.so.mreturnpolicy.model.ReturnPolicyValidationService)context.get("batchValidateSerice");
  nc.ui.so.mreturnpolicy.model.ReturnPolicyValidationService bean = new nc.ui.so.mreturnpolicy.model.ReturnPolicyValidationService();
  context.put("batchValidateSerice",bean);
  bean.setEditor(getList());
return bean;
}

public nc.ui.so.mreturnpolicy.model.ReturnPolicyModel getBatchBillTableModel(){
 if(context.get("batchBillTableModel")!=null)
 return (nc.ui.so.mreturnpolicy.model.ReturnPolicyModel)context.get("batchBillTableModel");
  nc.ui.so.mreturnpolicy.model.ReturnPolicyModel bean = new nc.ui.so.mreturnpolicy.model.ReturnPolicyModel();
  context.put("batchBillTableModel",bean);
  bean.setContext(getContext());
  bean.setService(getBatchModelService());
  bean.setBusinessObjectAdapterFactory(getBoadatorfactory());
  bean.setValidationService(getBatchValidateSerice());
return bean;
}

public nc.ui.pubapp.uif2app.model.BatchModelDataManager getModelDataManager(){
 if(context.get("modelDataManager")!=null)
 return (nc.ui.pubapp.uif2app.model.BatchModelDataManager)context.get("modelDataManager");
  nc.ui.pubapp.uif2app.model.BatchModelDataManager bean = new nc.ui.pubapp.uif2app.model.BatchModelDataManager();
  context.put("modelDataManager",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setService(getBatchModelService());
return bean;
}

public nc.ui.uif2.editor.TemplateContainer getTemplateContainer(){
 if(context.get("templateContainer")!=null)
 return (nc.ui.uif2.editor.TemplateContainer)context.get("templateContainer");
  nc.ui.uif2.editor.TemplateContainer bean = new nc.ui.uif2.editor.TemplateContainer();
  context.put("templateContainer",bean);
  bean.setContext(getContext());
  bean.load();
return bean;
}

public nc.ui.pubapp.uif2app.view.OrgPanel getOrgPanel(){
 if(context.get("orgPanel")!=null)
 return (nc.ui.pubapp.uif2app.view.OrgPanel)context.get("orgPanel");
  nc.ui.pubapp.uif2app.view.OrgPanel bean = new nc.ui.pubapp.uif2app.view.OrgPanel();
  context.put("orgPanel",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setDataManager(getModelDataManager());
  bean.setType("销售组织");/*-=notranslate=-*/
  bean.initUI();
return bean;
}

public nc.ui.uif2.editor.value.BillCardPanelMetaDataValueAdapter getComponentValueManager(){
 if(context.get("componentValueManager")!=null)
 return (nc.ui.uif2.editor.value.BillCardPanelMetaDataValueAdapter)context.get("componentValueManager");
  nc.ui.uif2.editor.value.BillCardPanelMetaDataValueAdapter bean = new nc.ui.uif2.editor.value.BillCardPanelMetaDataValueAdapter();
  context.put("componentValueManager",bean);
return bean;
}

public nc.ui.so.mreturnpolicy.view.ReturnPolicyBillView getList(){
 if(context.get("list")!=null)
 return (nc.ui.so.mreturnpolicy.view.ReturnPolicyBillView)context.get("list");
  nc.ui.so.mreturnpolicy.view.ReturnPolicyBillView bean = new nc.ui.so.mreturnpolicy.view.ReturnPolicyBillView();
  context.put("list",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setComponentValueManager(getComponentValueManager());
  bean.setIsBodyAutoAddLine(false);
  bean.setMoreRowEdit(false);
  bean.setBodyMultiSelectEnable(true);
  bean.setAddLineAction(getAddAction());
  bean.initUI();
return bean;
}

public nc.funcnode.ui.action.GroupAction getMaintainActionGroup(){
 if(context.get("maintainActionGroup")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("maintainActionGroup");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("maintainActionGroup",bean);
  bean.setCode("maintain");
  bean.setName("打印");/*-=notranslate=-*/
  bean.setActions(getManagedList0());
return bean;
}

public List getManagedList0(){  List list = new ArrayList();  list.add(getPrintAction());  list.add(getPreviewAction());  return list;}

public nc.ui.so.mreturnpolicy.action.ReturnPolicyAddLineAction getAddAction(){
 if(context.get("addAction")!=null)
 return (nc.ui.so.mreturnpolicy.action.ReturnPolicyAddLineAction)context.get("addAction");
  nc.ui.so.mreturnpolicy.action.ReturnPolicyAddLineAction bean = new nc.ui.so.mreturnpolicy.action.ReturnPolicyAddLineAction();
  context.put("addAction",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setVoClassName("nc.vo.so.mreturnpolicy.entity.ReturnPolicyVO");
return bean;
}

public nc.ui.so.mreturnpolicy.action.ReturnPolicyEditAction getEditAction(){
 if(context.get("editAction")!=null)
 return (nc.ui.so.mreturnpolicy.action.ReturnPolicyEditAction)context.get("editAction");
  nc.ui.so.mreturnpolicy.action.ReturnPolicyEditAction bean = new nc.ui.so.mreturnpolicy.action.ReturnPolicyEditAction();
  context.put("editAction",bean);
  bean.setModel(getBatchBillTableModel());
return bean;
}

public nc.ui.so.mreturnpolicy.action.ReturnPolicyDelAction getDelAction(){
 if(context.get("delAction")!=null)
 return (nc.ui.so.mreturnpolicy.action.ReturnPolicyDelAction)context.get("delAction");
  nc.ui.so.mreturnpolicy.action.ReturnPolicyDelAction bean = new nc.ui.so.mreturnpolicy.action.ReturnPolicyDelAction();
  context.put("delAction",bean);
  bean.setModel(getBatchBillTableModel());
return bean;
}

public nc.ui.uif2.actions.batch.BatchSaveAction getSaveAction(){
 if(context.get("saveAction")!=null)
 return (nc.ui.uif2.actions.batch.BatchSaveAction)context.get("saveAction");
  nc.ui.uif2.actions.batch.BatchSaveAction bean = new nc.ui.uif2.actions.batch.BatchSaveAction();
  context.put("saveAction",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setEditor(getList());
  bean.setValidationService(getBatchValidateSerice());
return bean;
}

public nc.ui.so.mreturnpolicy.action.ReturnPoliceCancleAction getCancelAction(){
 if(context.get("cancelAction")!=null)
 return (nc.ui.so.mreturnpolicy.action.ReturnPoliceCancleAction)context.get("cancelAction");
  nc.ui.so.mreturnpolicy.action.ReturnPoliceCancleAction bean = new nc.ui.so.mreturnpolicy.action.ReturnPoliceCancleAction();
  context.put("cancelAction",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setEditor(getList());
return bean;
}

public nc.ui.pubapp.uif2app.actions.SingleTablePrintAction getPrintAction(){
 if(context.get("printAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.SingleTablePrintAction)context.get("printAction");
  nc.ui.pubapp.uif2app.actions.SingleTablePrintAction bean = new nc.ui.pubapp.uif2app.actions.SingleTablePrintAction();
  context.put("printAction",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setEditor(getList());
  bean.setPreview(false);
return bean;
}

public nc.ui.pubapp.uif2app.actions.SingleTablePrintAction getPreviewAction(){
 if(context.get("previewAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.SingleTablePrintAction)context.get("previewAction");
  nc.ui.pubapp.uif2app.actions.SingleTablePrintAction bean = new nc.ui.pubapp.uif2app.actions.SingleTablePrintAction();
  context.put("previewAction",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setEditor(getList());
  bean.setPreview(true);
return bean;
}

public nc.ui.so.mreturnpolicy.action.ReturnPoliceRefrshAction getRefreshAction(){
 if(context.get("refreshAction")!=null)
 return (nc.ui.so.mreturnpolicy.action.ReturnPoliceRefrshAction)context.get("refreshAction");
  nc.ui.so.mreturnpolicy.action.ReturnPoliceRefrshAction bean = new nc.ui.so.mreturnpolicy.action.ReturnPoliceRefrshAction();
  context.put("refreshAction",bean);
  bean.setModel(getBatchBillTableModel());
  bean.setManager(getModelDataManager());
return bean;
}

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setTangramLayoutRoot(getVSNode_3ac075());
  bean.setActions(getManagedList1());
  bean.setEditActions(getManagedList2());
  bean.setModel(getBatchBillTableModel());
  bean.initUI();
return bean;
}

public nc.ui.uif2.tangramlayout.node.VSNode getVSNode_3ac075(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#3ac075")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#3ac075");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#3ac075",bean);
  bean.setDown(getCNode_19fa357());
  bean.setUp(getCNode_19cb913());
  bean.setDividerLocation(31f);
return bean;
}

public nc.ui.uif2.tangramlayout.node.CNode getCNode_19fa357(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#19fa357")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#19fa357");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#19fa357",bean);
  bean.setComponent(getList());
return bean;
}

public nc.ui.uif2.tangramlayout.node.CNode getCNode_19cb913(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#19cb913")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#19cb913");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#19cb913",bean);
  bean.setComponent(getOrgPanel());
return bean;
}

public List getManagedList1(){  List list = new ArrayList();  list.add(getAddAction());  list.add(getEditAction());  list.add(getDelAction());  list.add(getSeparatorAction_1317efd());  list.add(getRefreshAction());  list.add(getSeparatorAction_8841ca());  list.add(getMaintainActionGroup());  return list;}

public nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1317efd(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1317efd")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1317efd");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1317efd",bean);
return bean;
}

public nc.funcnode.ui.action.SeparatorAction getSeparatorAction_8841ca(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#8841ca")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#8841ca");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#8841ca",bean);
return bean;
}

public List getManagedList2(){  List list = new ArrayList();  list.add(getSaveAction());  list.add(getSeparatorAction_19755df());  list.add(getCancelAction());  return list;}

public nc.funcnode.ui.action.SeparatorAction getSeparatorAction_19755df(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#19755df")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#19755df");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#19755df",bean);
return bean;
}

}
