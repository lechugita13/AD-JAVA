#include "DBuscarRemplazar.h"

DBuscarRemplazar::DBuscarRemplazar(QString bobo,QWidget * parent) : QDialog(parent){

	setupUi(this);
	leBuscar->setText(bobo);
}
