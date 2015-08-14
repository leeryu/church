package com.church.common;

/**
 * <pre>
 * Class Name  : ComConstants.java
 * Description : 
 * Modification Information  
 * 
 *    수정일　　　 　　     수정자　　　      수정내용
 *    -------------   ----------   ---------------------------
 *    2015. 9. 16.      이민욱         최초생성
 * </pre>
 *
 * @author 이민욱
 * @since 2015. 9. 16.
 * @version 1.0
 * 
 */
public enum ComConstants {

    LINE_SEPARATOR,
    PAGE_DEFAULT_UNIT_SIZE,
    PAGE_DEFAULT_PAGE_SIZE,
    INSERT,
    UPDATE,
    DELETE,
    SELECT;

    @Override public String toString() {
        switch (this){
            case LINE_SEPARATOR:return "\n";
            case PAGE_DEFAULT_UNIT_SIZE:return "10";
            case PAGE_DEFAULT_PAGE_SIZE:return "10";
            case INSERT:return "Insert";
            case UPDATE:return "Update";
            case DELETE:return "Delete";
            case SELECT:return "Select";
            default:return "";
        }
    }
}
