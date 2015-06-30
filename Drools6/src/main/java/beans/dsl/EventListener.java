package beans.dsl;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

public class EventListener implements AgendaEventListener {

	public void afterMatchFired(AfterMatchFiredEvent arg0) {
//		System.out.println("afterMatchFired"+arg0.getMatch());
		System.out.println(" Regla lanzada!!! "+arg0.getMatch().getRule().getName());
		
	}

	
	

	public void beforeMatchFired(BeforeMatchFiredEvent arg0) {
		System.out.println("beforeMatchFired"+arg0.getMatch());
		
	}

	
	public void matchCreated(MatchCreatedEvent arg0) {
		System.out.println("matchCreated"+arg0.getMatch());
		
	}

	public void agendaGroupPopped(AgendaGroupPoppedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void agendaGroupPushed(AgendaGroupPushedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void matchCancelled(MatchCancelledEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
