package scala.git

import java.io.File
import java.io.FileNotFoundException

object Repository{
    def isGitRepo(path: String):Boolean= {
        return false;
    }
}
//.git
//├── branches
//├── config
//├── description
//├── HEAD         (mandatory)
//├── hooks
//│   ├── applypatch-msg.sample
//│   ├── commit-msg.sample
//│   ├── post-update.sample
//│   ├── pre-applypatch.sample
//│   ├── pre-commit.sample
//│   ├── prepare-commit-msg.sample
//│   ├── pre-rebase.sample
//│   └── update.sample
//├── info
//│   └── exclude
//├── objects      (mandatory)
//│   ├── info
//│   └── pack
//└── refs         (mandatory)
//    ├── head
//    └── tags

/*
 * Reference
 *   http://www.kernel.org/pub/software/scm/git/docs/gitglossary.html
 *
 * A collection of refs together with an object database containing
 * all objects which are reachable from the refs, possibly accompanied
 * by meta data from one or more porcelains.
 *
 * A repository can share an object database with other repositories via
 * alternates mechanism.
 *
 */
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
    private val working_dir :String = path;

    require(checkDir(working_dir+"/.git"));
    private val git_repo_dir: String = working_dir+"/.git";

    require(checkDir(git_repo_dir+"/objects"));
    private val git_objects_dir: String = git_repo_dir+"/objects";

    require(checkDir(git_repo_dir+"/refs"));
    private val git_refs_dir: String = git_repo_dir+"/refs";


    // HEAD
    // The current branch.
    // In more detail: Your working tree is normally derived from the state
    // of the tree referred to by HEAD. HEAD is a reference to one of the
    // heads in your repository, except when using a detached HEAD, in which
    // case it directly references an arbitrary commit.
    val HEAD_path = git_repo_dir+"/HEAD"

    require((new File(HEAD_path)).exists());
    private var HEAD: SymRef = new SymRef(HEAD_path);

    //println("HEAD:\n"+HEAD.toString())


    // The default development branch. Whenever you create a git repository,
    // a branch named "master" is created, and becomes the active branch.
    // In most cases, this contains the local development, though that is
    // purely by convention and is not required.
    private var master: Long = 0;

    def isGitRepo() : Boolean = {
        return false;
    }

    override def toString(): String = {
        "Git working directory: " + working_dir + "\n" +
        "Git repository: " +git_repo_dir + "\n";
    }



}