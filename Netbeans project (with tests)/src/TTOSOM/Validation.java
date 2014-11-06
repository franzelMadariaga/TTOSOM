/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TTOSOM;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 * This class is a superclass that performs the validation of the TTOSOM algorithm. 
 * The validation can be ten cross validation or train test set.
 * 
 * @author Franzel Madariaga
 */
public class Validation {
    private String validationType;
    private TTOSOM ttosom;
    private Instances dataSet;
    private Evaluation eval; 
        
    public Validation(String validationType, TTOSOM ttosom, Instances dataSet) {
        this.validationType = validationType;
        this.ttosom = ttosom;
        this.dataSet = dataSet;
        
        try {
            this.eval = new Evaluation(dataSet);
            
        } catch (Exception ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method valid and shows the outputs such as the summary, the class details and the confusion matrix.
     * 
     */
    public void validate(){
        if(validationType.equals("trainTestSet")){
            System.out.println("Training and test sets");
        }
        else if(validationType.equals("crossValidation")){
            System.out.println("Cross Validation");
        
        }
                
        getSummary();
        getClassDetails();
        getConfusionMatrix();
    }  
    
    /**
     * Method that show the summary of the validation.
     * 
     */
    public void getSummary(){
        System.out.println(eval.toSummaryString());
    }
        
    /**
     * Method that show the class details of the validation.
     * 
     */
    public void getClassDetails(){
        try {
            System.out.println(eval.toClassDetailsString());
        } catch (Exception ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method that show the confusion matrix of the validation.
     * 
     */
    public void getConfusionMatrix(){
        
        try {
            System.out.println(eval.toMatrixString());
        } catch (Exception ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TTOSOM getTtosom() {
        return ttosom;
    }

    public void setTtosom(TTOSOM ttosom) {
        this.ttosom = ttosom;
    }

    public Evaluation getEval() {
        return eval;
    }

    public void setEval(Evaluation eval) {
        this.eval = eval;
    }
    
    
    
    
}
