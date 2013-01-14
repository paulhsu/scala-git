package scala.git

import java.io.File
import java.io.FileNotFoundException

object Repository{
    def isGitRepo(path: String):Boolean= {
        return false;
    }
}

class Repository(path:String) {
    
    private def checkDir(path:String):Boolean = {
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
    
    require(checkDir(path));
    private var base_dir :String = path;
    
    require(checkDir(base_dir+"/.git"));
    private var git_base_dir: String = base_dir+"/.git";
    
    // a reference to the end of a branch 
    private var master: Long = 0;
    
    // a special type of reference that points to another reference
    private var HEAD: Long = 0;
    
    def isGitRepo() : Boolean = {
        return false;
    }        
    
    override def toString(): String = {
        "Git directory: " + base_dir + "\n" +
        "Git repository: " +git_base_dir + "\n";
    }
    
    

}