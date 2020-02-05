import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteUnoDosComponent } from './componente-uno-dos.component';

describe('ComponenteUnoDosComponent', () => {
  let component: ComponenteUnoDosComponent;
  let fixture: ComponentFixture<ComponenteUnoDosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponenteUnoDosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteUnoDosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
