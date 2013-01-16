package scala.git

import java.io.File


/*
 * ref
 * A 40-byte hex representation of a SHA1 or a name that denotes a particular
 * object. They may be stored in a file under $GIT_DIR/refs/ directory, or in
 * the $GIT_DIR/packed-refs file.
 *
 */
class Ref(path: String) {
    require((new File(path)).exists())
    private val mFile = new File(path);
}