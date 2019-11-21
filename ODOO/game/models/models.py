# -*- coding: utf-8 -*-

from odoo import models, fields, api


class player(models.Model):
    _name = 'game.player'
    name = fields.Char()
    planetes = fields.One2many('game.planets', 'player')


class planets(models.Model):
    _name = 'game.planets'
    name = fields.Char()
    player = fields.Many2one('game.player')
    image = fields.Binary()
    metal = fields.Float(default=500.0)
    cristal = fields.Float(default=500.0)
    energia = fields.Float(default=0.0)
    materiaOscura = fields.Float(default=0.0)


class fleet(models.Model):
    _name = 'game.fleet'
    name = fields.Char()
