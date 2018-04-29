package com.ide2e.TestSuite;
import com.ide2e.service.FileSearchService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	    FileSearchService service = new FileSearchService();
    	    service.findAllSupportedFiles().forEach( a ->{
    	    	    System.out.println ("extension : " + a.getFileExtension());
    	    	    System.out.println ("Name : " + a.getFileName());
    	    });
    }
}
