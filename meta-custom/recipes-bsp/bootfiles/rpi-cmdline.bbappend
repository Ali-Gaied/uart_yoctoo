FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://cmdline.txt"

do_deploy:append() {
    # Remplacer le cmdline.txt par défaut
    install -m 0644 ${WORKDIR}/cmdline.txt ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/cmdline.txt
}
