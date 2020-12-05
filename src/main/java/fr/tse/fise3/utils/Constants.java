package fr.tse.fise3.utils;

/**
 * 
 * @author ALAMI IDRISSI Taha
 * @version 1.0 This class will propagate some constants which will help us test
 *          and seed data in our H2 DB
 */
public class Constants {

	// Task Status ID declarations
	public static final Long TASK_STATUS_ID_TODO = 1L;
	public static final Long TASK_STATUS_ID_DOING = 2L;
	public static final Long TASK_STATUS_ID_TEST = 3L;
	public static final Long TASK_STATUS_ID_DONE = 4L;

	// Task Status Label declarations
	public static final String TASK_STATUS_LABEL_TODO = "TODO";
	public static final String TASK_STATUS_LABEL_DOING = "DOING";
	public static final String TASK_STATUS_LABEL_TEST = "TEST";
	public static final String TASK_STATUS_LABEL_DONE = "DONE";

	// Task Types ID declarations
	public static final Long TASK_TYPES_ID_BUG = 1L;
	public static final Long TASK_TYPES_ID_FEATURE= 2L;

	// Task Types Label declarations
	public static final String TASK_TYPES_LABEL_BUG = "BUG";
	public static final String TASK_TYPES_LABEL_FEATURE = "FEATURE";
	
}
