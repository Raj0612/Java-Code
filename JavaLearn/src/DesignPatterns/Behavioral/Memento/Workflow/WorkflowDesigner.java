package DesignPatterns.Behavioral.Memento.Workflow;

import java.util.Arrays;

public class WorkflowDesigner {

    private Workflow workflow;

    public void createWorkflow(String name) {
        workflow = new Workflow(name);
    }

    public Workflow getWorkflow() {
        return this.workflow;
    }

    public Memento getMemento() {
       // System.out.println("getMemento: workflow " + workflow);
       if(workflow == null) {
    	   return new Memento();
       }
       return new Memento(workflow.getSteps(), workflow.getName());
    }

    public void setMemento(Memento memento) {
    	if(memento.isEmpty()) {
    		this.workflow = null;
    	} else {
    		this.workflow = new Workflow(memento.getName(), memento.getSteps());
    	}
    }

    public void addStep(String step) {
        workflow.addStep(step);
    }

    public void removeStep(String step) {
        workflow.removeStep(step);
    }

    public void print() {
        System.out.println(workflow);
    }
    //Memento
    public class Memento {
    	
    	private String[] steps;
    	
    	public String name;
    	
    	private Memento() {
    		
    	}
    	
    	private Memento(String[] steps, String name) {
    		this.steps = steps;
    		this.name = name;
            System.out.println("Memento steps : " + Arrays.toString(steps));
    	}
    	
    	private String[] getSteps() {
    		return steps;
    	}

        @Override
        public String toString() {
            return "Memento " + this.name;
        }

        private String getName() {
    		return name;
    	}
    	
    	private boolean isEmpty() {
    		return this.getSteps() == null && this.getName() == null;
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
