import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DynamiqueImageSearchComponent } from './dynamique-image-search.component';

describe('DynamiqueImageSearchComponent', () => {
  let component: DynamiqueImageSearchComponent;
  let fixture: ComponentFixture<DynamiqueImageSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DynamiqueImageSearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DynamiqueImageSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
