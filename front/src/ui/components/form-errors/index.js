import React from 'react'

export function AmFormErrors({formErrors}) {
  return (
    <div className='formErrors'>
      {formErrors.map((error, key) => {
        return <p key={key}>{error}</p>
      })}
    </div>
  )
}
