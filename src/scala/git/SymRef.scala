package scala.git
/*
 * symref
 * Symbolic reference: instead of containing the SHA1 id itself, it is of the
 * format ref: refs/some/thing and when referenced, it recursively
 * dereferences to this reference.
 * HEAD is a prime example of a symref. Symbolic references are manipulated
 * with the git-symbolic-ref(1) command.
 */
class SymRef(path: String) {

}