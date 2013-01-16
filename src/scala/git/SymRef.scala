package scala.git

import java.io.File
import scala.io.Source
/*
 * symref
 * Symbolic reference: instead of containing the SHA1 id itself, it is of the
 * format ref: refs/some/thing and when referenced, it recursively
 * dereferences to this reference.
 * HEAD is a prime example of a symref. Symbolic references are manipulated
 * with the git-symbolic-ref(1) command.
 */
class SymRef(path: String) {

    private val mFile = {
        val file = new File(path);
        if(file.exists()){
            file
        }else{
            throw new IllegalArgumentException()
        }
    }

    private val mRefTo = {
        readContent(mFile.getAbsolutePath())
    }
    
    private def readContent(path: String):String = {
        val lines = Source.fromFile(path).getLines;
        if(lines.hasNext){
            val ref = lines.next()
            ref
        }else{
            ""
        }
    }
    
    def dereference(): String = {
        readContent(mRefTo)
    }

    override def toString(): String = {
        "SymRef: " + mFile.getAbsolutePath() + "\n"+
        "RefTo: " + mRefTo + "\n"
    }
}