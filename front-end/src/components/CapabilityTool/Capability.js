import React, { Component } from "react";

export class Capability extends Component {
  render() {
    const {
      id,
      numOfAvailableDevelopers,
      numOfDevelopers,
      techStack,
      _links
    } = this.props.capability;

    return (
      <div className="card card-body border-primary mb-3">
        <h4 className="text-primary">
          {techStack}...{_links.getThisCapability.href}
          <i className="fas fa-user-edit ml-2" style={{ color: "blue" }} />
          <i className="fas fa-user-times ml-2" style={{ color: "red" }} />
        </h4>

        <ul className="list-group">
          <li className="list-group-item bg-light text-primary">
            Technology Stack: {techStack}
          </li>
          <li className="list-group-item bg-light  text-primary">
            Total Developers in Capability: {numOfDevelopers}
          </li>
          <li className="list-group-item bg-light  text-primary">
            Available developers for hire: {numOfAvailableDevelopers}
          </li>
        </ul>
      </div>
    );
  }
}

export default Capability;
