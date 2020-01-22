#ifndef _DBUSCARREMPLAZAR_H
#define _DBUSCARREMPLAZAR_H

#include "ui_DBuscarRemplazar.h"
#include <QDialog>
#include <QString>
#include <QLineEdit>

class DBuscarRemplazar : public QDialog, public Ui::DBuscarRemplazar {

Q_OBJECT
public:
	DBuscarRemplazar(QString cadena,QWidget * parent = 0);
	
	

};
#endif