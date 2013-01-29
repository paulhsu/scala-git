package scala.git

object Object{

}



/*
 * The unit of storage in git. It is uniquely identified
 * by the SHA1 of its contents. Consequently, an object
 * can not be changed.
 *
 */
class Object(objdb:String,name:String) {


    // object database
    //   Stores a set of "objects", and an individual object
    //   is identified by its object name. The objects usually
    //   live in $GIT_DIR/objects/.
    val mObjDB = objdb

    // The unique identifier of an object. The hash of the
    // object’s contents using the Secure Hash Algorithm 1
    // and usually represented by the 40 character hexadecimal
    // encoding of the hash of the object.
    val mName = name


    import scala.git.GitObjType
    // One of the identifiers "commit", "tree", "tag" or "blob"
    val mtype= GitObjType.Commit


}