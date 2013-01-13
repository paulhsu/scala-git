package scala.git

import java.io.File
import java.io.FileNotFoundException

object Repository{
    def isGitRepo(path: String):Boolean= {
        return false;
    }
}

class Repository(path:String) {
    
    def checkDir(path:String):Boolean = {
        val dir = new File(path);
        if (dir.exists()) {
        	if (dir.isDirectory()) {        	    
        	    return true
        	} else {
        		throw new IllegalArgumentException("Not a valid folder");
        	}
        } else {
        	throw new FileNotFoundException();
        }
        false;
    }       
    private var base_dir :String = "";
       
    private var git_base_dir: String = "";
    
    // a reference to the end of a branch 
    private var master: Long = 0;
    
    // a special type of reference that points to another reference
    private var HEAD: Long = 0;
    
    def isGitRepo() : Boolean = {
        return false;
    }
        
    if(checkDir(path)) base_dir = path;
    if(checkDir(base_dir+"/.git")) git_base_dir = base_dir+"/.git";
    
    override def toString(): String = {
        "Git directory: " + base_dir + "\n" +
        "Git repository: " +git_base_dir + "\n";
    }
    
    

}